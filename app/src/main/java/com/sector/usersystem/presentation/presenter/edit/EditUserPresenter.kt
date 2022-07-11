package com.sector.usersystem.presentation.presenter.edit

import com.sector.usersystem.entity.User
import com.sector.usersystem.extensions.withMain
import com.sector.usersystem.model.interactor.UserInteractor
import com.sector.usersystem.presentation.presenter.common.BaseMvpPresenter
import com.sector.usersystem.presentation.view.edit.EditUserView
import kotlinx.coroutines.launch
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class EditUserPresenter
@Inject
constructor(
    val userInteractor: UserInteractor
): BaseMvpPresenter<EditUserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun updateUser(id: Int, name: String, surname: String, action: () -> Unit) {
        scope.launch {
            val user = User(
                id = id,
                name = name,
                surname = surname
            )

            withMain {
                action.invoke()
            }

            userInteractor.updateUser(user)
        }
    }

    fun deleteUser(id: Int, name: String, surname: String) {
        scope.launch {
            val user = User(
                id = id,
                name = name,
                surname = surname
            )

            userInteractor.deleteUser(user)
        }
    }
}