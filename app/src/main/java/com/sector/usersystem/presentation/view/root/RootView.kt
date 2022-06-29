package com.sector.usersystem.presentation.view.root

import com.sector.usersystem.model.data.local.RecyclerViewType
import com.sector.usersystem.presentation.view.common.BaseMvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution

@AddToEndSingle
interface RootView: BaseMvpView {

    fun setRootRv(items: MutableList<RecyclerViewType>)

    @OneExecution
    fun onAdd()

    fun loadUsers()
}