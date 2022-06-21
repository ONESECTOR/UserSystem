package com.sector.usersystem

import android.os.Bundle
import androidx.core.view.WindowCompat
import com.sector.usersystem.presentation.presenter.common.activity.ActivityPresenter
import com.sector.usersystem.presentation.view.activity.ActivityView
import com.sector.usersystem.ui.common.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class MainActivity : BaseActivity(R.layout.activity_main), ActivityView {

    @Inject
    lateinit var presenterProvider: Provider<ActivityPresenter>

    private val presenter: ActivityPresenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}