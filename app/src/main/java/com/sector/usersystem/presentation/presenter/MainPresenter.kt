package com.sector.usersystem.presentation.presenter

import com.sector.usersystem.presentation.presenter.common.BaseMvpPresenter
import com.sector.usersystem.presentation.view.main.MainView
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class MainPresenter
@Inject
constructor(): BaseMvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

}