package com.sector.usersystem.extensions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

fun <T : ViewBinding> ViewGroup.binding(
    creator: (inflater: LayoutInflater, parent: ViewGroup, attachToRoot: Boolean) -> T
): T = creator(
    LayoutInflater.from(context),
    this,
    false
)