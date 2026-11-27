package com.propresets.camera

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.WindowInsets
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cameraVersion = XiaomiCamera.installedVersion(this)
        val spacing = (resources.displayMetrics.density * 16).toInt()
        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL

            addView(TextView(context).apply {
                setText(R.string.probe_title)
                textSize = 24f
            })
            addView(TextView(context).apply {
                text = getString(
                    R.string.device_details, Build.MANUFACTURER, Build.MODEL,
                    Build.VERSION.RELEASE, Build.VERSION.SDK_INT,
                )
            })
            addView(TextView(context).apply {
                text = if (cameraVersion == null) {
                    getString(R.string.camera_missing)
                } else {
                    getString(R.string.camera_details, XiaomiCamera.PACKAGE, cameraVersion)
                }
            })
            addView(TextView(context).apply {
                setPadding(0, spacing, 0, spacing)
                setText(R.string.probe_hint)
            })
            addView(Button(context).apply {
                setText(R.string.settings_open)
                setOnClickListener { startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)) }
            })
            addView(Button(context).apply {
                setText(R.string.camera_open)
                isEnabled = cameraVersion != null
                setOnClickListener { openCamera() }
            })
        }

        setContentView(ScrollView(this).apply {
            addView(content)
            setOnApplyWindowInsetsListener { _, insets ->
                val safeArea = insets.getInsets(
                    WindowInsets.Type.systemBars() or WindowInsets.Type.displayCutout(),
                )
                content.setPadding(
                    spacing + safeArea.left, spacing + safeArea.top,
                    spacing + safeArea.right, spacing + safeArea.bottom,
                )
                insets
            }
        })
    }

    private fun openCamera() {
        if (XiaomiCamera.installedVersion(this) != null) {
            for (intent in XiaomiCamera.launchIntents(this)) {
                try {
                    startActivity(intent)
                    return
                } catch (_: ActivityNotFoundException) {
                    // Some camera versions only expose the launcher activity.
                } catch (_: SecurityException) {
                    // The activity can be present and unavailable to third-party apps.
                }
            }
        }
        Toast.makeText(this, R.string.camera_open_error, Toast.LENGTH_SHORT).show()
    }
}
