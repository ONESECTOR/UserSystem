package com.sector.usersystem

import android.os.Bundle
import androidx.core.view.WindowCompat
import com.sector.usersystem.presentation.presenter.MainPresenter
import com.sector.usersystem.presentation.view.main.MainView
import com.sector.usersystem.ui.common.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class MainActivity : BaseActivity(R.layout.activity_main), MainView {

    @Inject
    lateinit var presenterProvider: Provider<MainPresenter>

    private val presenter: MainPresenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}