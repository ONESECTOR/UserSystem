package com.sector.usersystem.presentation.presenter.add

import com.sector.usersystem.entity.User
import com.sector.usersystem.model.interactor.UserInteractor
import com.sector.usersystem.presentation.presenter.common.BaseMvpPresenter
import com.sector.usersystem.presentation.view.add.AddUserView
import kotlinx.coroutines.launch
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class AddUserPresenter
@Inject
constructor(
    private val userInteractor: UserInteractor
): BaseMvpPresenter<AddUserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun addUser(name: String, surname: String) {
        scope.launch {
            val user = User(0, name, surname)

            userInteractor.addUser(user)
        }
    }
}