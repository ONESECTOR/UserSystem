package com.sector.usersystem.extensions

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DimenRes
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
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

@SuppressLint("RestrictedApi")
fun View.addSystemBottomMargin(
    @DimenRes initialMargin: Int = 0,
    targetView: View = this
) {
    ViewUtils.doOnApplyWindowInsets(
        targetView
    ) { _, insets, initialPadding ->

        targetView.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            bottomMargin = when (initialMargin) {
                0 -> {
                    insets.systemWindowInsetBottom
                }
                else -> {
                    resources.getDimensionPixelSize(initialMargin) + insets.systemWindowInsetBottom
                }
            }
        }
        insets
    }
}