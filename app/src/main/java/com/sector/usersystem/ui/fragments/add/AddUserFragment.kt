package com.sector.usersystem.ui.fragments.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sector.usersystem.databinding.FragmentAddUserBinding
import com.sector.usersystem.extensions.addSystemBottomMargin
import com.sector.usersystem.extensions.addSystemTopPadding
import com.sector.usersystem.extensions.hideSoftKeyboard
import com.sector.usersystem.extensions.navigateUp
import com.sector.usersystem.presentation.presenter.add.AddUserPresenter
import com.sector.usersystem.presentation.view.add.AddUserView
import com.sector.usersystem.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class AddUserFragment : BaseFragment<FragmentAddUserBinding>(), AddUserView {

    @Inject
    lateinit var presenterProvider: Provider<AddUserPresenter>

    private val presenter: AddUserPresenter by moxyPresenter { presenterProvider.get() }

    override fun onViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAddUserBinding = FragmentAddUserBinding.inflate(
        inflater,
        container,
        false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            root.addSystemTopPadding()
            btnAdd.addSystemBottomMargin()

            toolbar.setNavigationOnClickListener {
                hideSoftKeyboard()
                navigateUp()
            }

            btnAdd.setOnClickListener {
                getFromField()
                navigateUp()
            }
        }
    }

    private fun getFromField() {
        binding?.apply {
            val name = etName.text.toString()

            presenter.addUser(name)
        }
    }
}