package com.sector.usersystem.ui.fragments.root

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sector.usersystem.databinding.FragmentRootBinding
import com.sector.usersystem.extensions.addSystemTopPadding
import com.sector.usersystem.presentation.presenter.root.RootPresenter
import com.sector.usersystem.presentation.view.root.RootView
import com.sector.usersystem.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class RootFragment : BaseFragment<FragmentRootBinding>(), RootView {

    @Inject
    lateinit var presenterProvider: Provider<RootPresenter>

    private val presenter: RootPresenter by moxyPresenter { presenterProvider.get() }

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
        }
    }

}