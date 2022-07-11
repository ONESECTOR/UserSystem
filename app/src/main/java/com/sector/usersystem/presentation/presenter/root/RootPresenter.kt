package com.sector.usersystem.presentation.presenter.root

import com.sector.usersystem.entity.User
import com.sector.usersystem.extensions.withMain
import com.sector.usersystem.model.data.local.RecyclerViewType
import com.sector.usersystem.model.interactor.UserInteractor
import com.sector.usersystem.presentation.presenter.common.BaseMvpPresenter
import com.sector.usersystem.presentation.view.root.RootView
import com.sector.usersystem.ui.fragments.root.adapter.UserItem
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

        viewState.loadUsers()
    }

    private fun createUserItems(users: MutableList<User>) {
        scope.launch {
            val itemsList = mutableListOf<RecyclerViewType>()

            for (user in users) {
                itemsList.add(
                    UserItem(
                        id = user.id,
                        name = user.name,
                        surname = user.surname
                    )
                )
            }

            withMain {
                viewState.setRootRv(itemsList)
            }
        }
    }

    fun loadUsers() {
        scope.launch {
            val users = userInteractor.getUsers()

            createUserItems(users)
        }
    }

    fun deleteAllUsers() {
        scope.launch {
            userInteractor.deleteAllUsers()
        }
    }
}