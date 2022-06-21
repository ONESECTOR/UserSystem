package com.sector.usersystem.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sector.usersystem.databinding.FragmentShowUserBinding
import com.sector.usersystem.presentation.presenter.show.ShowUserPresenter
import com.sector.usersystem.presentation.view.show.ShowUserView
import com.sector.usersystem.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class ShowUserFragment : BaseFragment<FragmentShowUserBinding>(), ShowUserView {

    @Inject
    lateinit var presenterProvider: Provider<ShowUserPresenter>

    private val presenter: ShowUserPresenter by moxyPresenter { presenterProvider.get() }

    override fun onViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentShowUserBinding = FragmentShowUserBinding.inflate(
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