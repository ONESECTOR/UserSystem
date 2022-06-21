package com.sector.usersystem.presentation.presenter.edit

import com.sector.usersystem.presentation.presenter.common.BaseMvpPresenter
import com.sector.usersystem.presentation.view.edit.EditUserView
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class EditUserPresenter
@Inject
constructor(): BaseMvpPresenter<EditUserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }
}