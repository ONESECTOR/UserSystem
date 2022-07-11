package com.sector.usersystem.ui.fragments.root

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.sector.usersystem.databinding.FragmentRootBinding
import com.sector.usersystem.extensions.addSystemBottomMargin
import com.sector.usersystem.extensions.addSystemTopPadding
import com.sector.usersystem.extensions.navigate
import com.sector.usersystem.model.data.local.RecyclerViewType
import com.sector.usersystem.presentation.presenter.root.RootPresenter
import com.sector.usersystem.presentation.view.root.RootView
import com.sector.usersystem.ui.common.BaseFragment
import com.sector.usersystem.ui.dialogs.DeleteAllUsersDialog
import com.sector.usersystem.ui.fragments.root.adapter.RootAdapter
import dagger.hilt.android.AndroidEntryPoint
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class RootFragment : BaseFragment<FragmentRootBinding>(), RootView {

    @Inject
    lateinit var presenterProvider: Provider<RootPresenter>

    private val presenter: RootPresenter by moxyPresenter { presenterProvider.get() }

    private val deleteAllUsersDialog by lazy {
        DeleteAllUsersDialog(
            onClick = {
                presenter.deleteAllUsers()
                presenter.loadUsers()
            }
        )
    }

    override fun onViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRootBinding = FragmentRootBinding.inflate(
        inflater,
        container,
        false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            root.addSystemTopPadding()
            btnDeleteAll.addSystemBottomMargin()

            btnAdd.setOnClickListener {
                onAdd()
            }

            btnDeleteAll.setOnClickListener {
                deleteAllUsersDialog.show(childFragmentManager, "TAG")
            }
        }
    }

    override fun setRootRv(items: MutableList<RecyclerViewType>) {
        binding?.rvUsers?.apply {
            adapter = ListDelegationAdapter(
                RootAdapter(
                    onClick = { id, name, surname ->
                        onEdit(id, name, surname)
                    }
                )
            ).apply {
                this.items = items

                notifyDataSetChanged()
            }
        }
    }

    override fun onAdd() {
        navigate(
            RootFragmentDirections.onAdd()
        )
    }

    override fun loadUsers() {
        presenter.loadUsers()
    }

    private fun onEdit(id: Int, name: String, surname: String) {
        navigate(
            RootFragmentDirections.onEdit(
                id = id,
                name = name,
                surname = surname
            )
        )
    }
}