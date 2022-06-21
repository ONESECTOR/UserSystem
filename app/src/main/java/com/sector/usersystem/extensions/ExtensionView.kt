package com.sector.usersystem.extensions

import android.annotation.SuppressLint
import android.view.View
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.google.android.material.internal.ViewUtils

@SuppressLint("RestrictedApi")
fun View.addSystemTopPadding(
    targetView: View = this
) {
    ViewUtils.doOnApplyWindowInsets(
        targetView
    ) { _, insets, initialPadding ->
        targetView.updatePadding(
            top = initialPadding.top + insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
        )
        insets
    }
}