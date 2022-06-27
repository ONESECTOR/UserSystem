package com.sector.usersystem.presentation.presenter.root

import com.sector.usersystem.model.interactor.UserInteractor
import com.sector.usersystem.presentation.presenter.common.BaseMvpPresenter
import com.sector.usersystem.presentation.view.root.RootView
import kotlinx.coroutines.launch
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class RootPresenter
@Inject
constructor(
    private val userInteractor: UserInteractor
): BaseMvpPresenter<RootView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

    }
}