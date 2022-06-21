package com.sector.usersystem.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sector.usersystem.databinding.FragmentAddUserBinding
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

        }
    }
}