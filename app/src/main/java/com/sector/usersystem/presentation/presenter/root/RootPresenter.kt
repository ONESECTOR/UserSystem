package com.sector.usersystem.presentation.presenter.root

import com.sector.usersystem.presentation.presenter.common.BaseMvpPresenter
import com.sector.usersystem.presentation.view.root.RootView
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class RootPresenter
@Inject
constructor(): BaseMvpPresenter<RootView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }
}