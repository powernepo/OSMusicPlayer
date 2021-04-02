package com.powernepo.common_android.extension

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

fun Context.checkSelfPermissionCompat(permission: String) =
    ActivityCompat.checkSelfPermission(this, permission)

fun Context.hasPermissionCompat(
    permission: String,
    permissionCheckResult: Int = PackageManager.PERMISSION_GRANTED
) =
    checkSelfPermissionCompat(permission) == permissionCheckResult

fun Context.hasPermissionsCompat(
    vararg permissions: String,
    permissionCheckResult: Int = PackageManager.PERMISSION_GRANTED,
    onPermissionDenied: (Array<out String>) -> Unit = {}
) =
    permissions.fold(initial = true, operation = { acc, permission ->
        hasPermissionCompat(
            permission,
            permissionCheckResult
        ) && acc
    }).also {
        it.takeUnless {
            it
        }?.let {
            onPermissionDenied(permissions)
        }
    }