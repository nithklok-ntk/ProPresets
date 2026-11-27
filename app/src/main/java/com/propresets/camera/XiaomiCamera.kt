package com.propresets.camera

import android.content.Context
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Build
import android.provider.MediaStore

internal object XiaomiCamera {
    const val PACKAGE = "com.android.camera"

    @Suppress("DEPRECATION") // API 31 and 32 use the original PackageManager overloads.
    fun installedVersion(context: Context): String? {
        if (!Build.MANUFACTURER.equals("Xiaomi", ignoreCase = true)) return null

        return try {
            val info = context.packageManager.getPackageInfo(PACKAGE, 0)
            val app = info.applicationInfo ?: return null
            val systemFlags = ApplicationInfo.FLAG_SYSTEM or ApplicationInfo.FLAG_UPDATED_SYSTEM_APP
            if (app.enabled && app.flags and systemFlags != 0) {
                info.versionName ?: info.longVersionCode.toString()
            } else {
                null
            }
        } catch (_: PackageManager.NameNotFoundException) {
            null
        }
    }

    fun launchIntents(context: Context): List<Intent> = listOfNotNull(
        Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA).setPackage(PACKAGE),
        context.packageManager.getLaunchIntentForPackage(PACKAGE),
    )
}
