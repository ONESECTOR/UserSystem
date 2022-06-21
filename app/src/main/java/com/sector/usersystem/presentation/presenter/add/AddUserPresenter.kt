package com.sector.usersystem.presentation.presenter.add

import com.sector.usersystem.presentation.presenter.common.BaseMvpPresenter
import com.sector.usersystem.presentation.view.add.AddUserView
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class AddUserPresenter
@Inject
constructor(): BaseMvpPresenter<AddUserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }
}