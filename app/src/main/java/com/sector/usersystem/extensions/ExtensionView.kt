package com.sector.usersystem.extensions

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.DimenRes
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.postDelayed
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding
import com.google.android.material.internal.ViewUtils

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

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

fun View.showSoftKeyboard(view: View = this, delayInMillis: Long = 200L) {
    if (view.requestFocus()) {
        view.postDelayed(delayInMillis) {
            val inputMethodManager =
                view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }
}

fun View.hideSoftKeyboard(view: View = this, requestParentFocus: Boolean = false) {
    val inputMethodManager =
        view.context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    view.clearFocus()
    when (requestParentFocus) {
        true -> {
            (view.parent as View).requestFocus()
        }
    }
}