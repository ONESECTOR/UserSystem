package com.sector.usersystem.ui.common

import androidx.annotation.LayoutRes
import com.sector.usersystem.presentation.view.common.BaseMvpView
import moxy.MvpAppCompatActivity

abstract class BaseActivity(@LayoutRes layoutResId: Int):
    MvpAppCompatActivity(layoutResId),
    BaseMvpView {


}