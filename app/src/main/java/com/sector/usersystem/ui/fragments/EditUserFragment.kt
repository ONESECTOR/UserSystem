package com.sector.usersystem.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sector.usersystem.databinding.FragmentEditUserBinding
import com.sector.usersystem.extensions.addSystemTopPadding
import com.sector.usersystem.presentation.presenter.edit.EditUserPresenter
import com.sector.usersystem.presentation.view.edit.EditUserView
import com.sector.usersystem.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class EditUserFragment : BaseFragment<FragmentEditUserBinding>(), EditUserView {

    @Inject
    lateinit var presenterProvider: Provider<EditUserPresenter>

    private val presenter: EditUserPresenter by moxyPresenter { presenterProvider.get() }

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
        }
    }
}