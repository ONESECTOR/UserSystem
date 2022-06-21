package com.sector.usersystem.presentation.presenter.common.activity

import com.sector.usersystem.presentation.presenter.common.BaseMvpPresenter
import com.sector.usersystem.presentation.view.activity.ActivityView
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class ActivityPresenter
@Inject
constructor(): BaseMvpPresenter<ActivityView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

}