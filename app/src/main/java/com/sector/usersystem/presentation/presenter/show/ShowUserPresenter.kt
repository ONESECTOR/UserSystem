package com.sector.usersystem.presentation.presenter.show

import com.sector.usersystem.presentation.presenter.common.BaseMvpPresenter
import com.sector.usersystem.presentation.view.show.ShowUserView
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class ShowUserPresenter
@Inject
constructor(): BaseMvpPresenter<ShowUserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }
}