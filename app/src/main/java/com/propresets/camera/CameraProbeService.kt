package com.propresets.camera

import android.accessibilityservice.AccessibilityService
import android.app.KeyguardManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.ApplicationInfo
import android.graphics.PixelFormat
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.PowerManager
import android.util.Log
import android.view.Gravity
import android.view.WindowManager
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import android.widget.Toast

@Suppress("DEPRECATION") // Node pooling and receiver registration on older Android versions.
class CameraProbeService : AccessibilityService() {
    private val handler = Handler(Looper.getMainLooper())
    private val windows by lazy { getSystemService(WINDOW_SERVICE) as WindowManager }
    private val keyguard by lazy { getSystemService(KEYGUARD_SERVICE) as KeyguardManager }
    private val power by lazy { getSystemService(POWER_SERVICE) as PowerManager }
    private val cameraPresent by lazy { XiaomiCamera.installedVersion(this) != null }
    private var overlay: Button? = null
    private var registered = false

    private val refresh = Runnable { refreshOverlay() }
    private val inspect = Runnable { inspectCamera() }
    private val screenOff = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) = reset()
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        if (!cameraPresent) return
        if (!registered) {
            val filter = IntentFilter(Intent.ACTION_SCREEN_OFF)
            if (Build.VERSION.SDK_INT >= 33) {
                registerReceiver(screenOff, filter, Context.RECEIVER_NOT_EXPORTED)
            } else {
                registerReceiver(screenOff, filter)
            }
            registered = true
        }
        refreshOverlay()
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        if (!cameraPresent) return
        // Window transitions from other packages only invalidate the camera overlay.
        if (event.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            val sourcePackage = event.packageName?.toString()
            if (sourcePackage != XiaomiCamera.PACKAGE && sourcePackage != packageName) reset()
        }
        if (!handler.hasCallbacks(inspect)) {
            handler.removeCallbacks(refresh)
            handler.post(refresh)
        }
    }

    override fun onInterrupt() = reset()

    override fun onDestroy() {
        reset()
        if (registered) unregisterReceiver(screenOff)
        super.onDestroy()
    }

    private fun cameraRoot(): AccessibilityNodeInfo? {
        if (!power.isInteractive || keyguard.isKeyguardLocked) return null
        val root = rootInActiveWindow ?: return null
        if (root.packageName?.toString() == XiaomiCamera.PACKAGE) return root
        root.recycle()
        return null
    }

    private fun refreshOverlay() {
        val root = cameraRoot()
        if (root == null) {
            hideOverlay()
            return
        }
        root.recycle()
        if (overlay != null) return

        val button = Button(this).apply {
            setText(R.string.inspect_camera)
            setOnClickListener {
                reset()
                // Let the camera regain the active window after releasing the overlay touch.
                handler.postDelayed(inspect, 150)
            }
        }
        val margin = (resources.displayMetrics.density * 16).toInt()
        val params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_ACCESSIBILITY_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT,
        ).apply {
            gravity = Gravity.TOP or Gravity.END
            x = margin
            y = margin
        }
        try {
            windows.addView(button, params)
            overlay = button
        } catch (_: WindowManager.BadTokenException) {
            Log.w(TAG, "Accessibility overlay unavailable")
        }
    }

    private fun inspectCamera() {
        val root = cameraRoot()
        if (root == null) {
            Toast.makeText(this, R.string.inspect_error, Toast.LENGTH_SHORT).show()
            refreshOverlay()
            return
        }
        val report = CameraTreeProbe.inspect(root)
        val message = if (report.truncated) R.string.inspect_incomplete else R.string.inspect_summary
        Toast.makeText(this, getString(message, report.candidates.size, report.visited), Toast.LENGTH_SHORT).show()
        if (applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0) {
            Log.i(TAG, "visited=${report.visited} candidates=${report.candidates.size} truncated=${report.truncated}")
            report.candidates.forEach { Log.i(TAG, it) }
        }
        refreshOverlay()
    }

    private fun reset() {
        handler.removeCallbacks(refresh)
        handler.removeCallbacks(inspect)
        hideOverlay()
    }

    private fun hideOverlay() {
        val button = overlay ?: return
        overlay = null
        try {
            windows.removeViewImmediate(button)
        } catch (_: IllegalArgumentException) {
            // Android may already have removed the window during service teardown.
        }
    }

    private companion object {
        const val TAG = "ProPresetsProbe"
    }
}
