package com.sector.usersystem.extensions

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

fun Fragment.navigate(destination: NavDirections) = with(findNavController()) {
    currentDestination?.getAction(destination.actionId)?.let {
        navigate(destination)
    }
}

fun Fragment.navigateUp() = findNavController().navigateUp()

fun Fragment.hideSoftKeyboard(requestParentFocus: Boolean = false) =
    requireActivity().currentFocus?.hideSoftKeyboard(
        requestParentFocus = requestParentFocus
    )