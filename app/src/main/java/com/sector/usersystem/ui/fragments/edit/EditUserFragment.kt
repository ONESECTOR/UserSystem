package com.sector.usersystem.ui.fragments.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.sector.usersystem.databinding.FragmentEditUserBinding
import com.sector.usersystem.extensions.addSystemTopPadding
import com.sector.usersystem.extensions.hideSoftKeyboard
import com.sector.usersystem.extensions.navigateUp
import com.sector.usersystem.presentation.presenter.edit.EditUserPresenter
import com.sector.usersystem.presentation.view.edit.EditUserView
import com.sector.usersystem.ui.common.BaseFragment
import com.sector.usersystem.ui.dialogs.DeleteUserDialog
import dagger.hilt.android.AndroidEntryPoint
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class EditUserFragment : BaseFragment<FragmentEditUserBinding>(), EditUserView {

    @Inject
    lateinit var presenterProvider: Provider<EditUserPresenter>

    private val presenter: EditUserPresenter by moxyPresenter { presenterProvider.get() }

    private val args: EditUserFragmentArgs by navArgs()

    private val deleteUserDialog by lazy {
        DeleteUserDialog(
            onClick = {
                deleteUser()
                navigateUp()
            }
        )
    }

    override fun onViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEditUserBinding = FragmentEditUserBinding.inflate(
        inflater,
        container,
        false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            root.addSystemTopPadding()

            toolbar.setNavigationOnClickListener {
                hideSoftKeyboard()
                navigateUp()
            }

            etName.setText(args.name)

            btnEdit.setOnClickListener {
                getFromField()
                navigateUp()
            }

            btnDelete.setOnClickListener {
                deleteUserDialog.show(childFragmentManager, "TAG")
            }
        }
    }

    private fun deleteUser() {
        binding?.apply {
            val id = args.id
            val name = etName.text.toString()

            presenter.deleteUser(id, name)
        }
    }


    private fun getFromField() {
        binding?.apply {
            val id = args.id
            val name = etName.text.toString()

            presenter.updateUser(id, name)
        }
    }
}