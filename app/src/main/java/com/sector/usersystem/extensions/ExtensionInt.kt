package com.sector.usersystem.extensions

fun Int.dpToPx(density: Float): Int = (this * density).toInt()