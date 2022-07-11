package com.sector.usersystem.ui.fragments.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.navArgs
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import com.sector.usersystem.databinding.FragmentEditUserBinding
import com.sector.usersystem.extensions.*
import com.sector.usersystem.presentation.presenter.edit.EditUserPresenter
import com.sector.usersystem.presentation.view.edit.EditUserView
import com.sector.usersystem.ui.common.BaseFragment
import com.sector.usersystem.ui.dialogs.DeleteUserDialog
import com.sector.usersystem.ui.dialogs.SaveUserDialog
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

    var fields: List<Pair<TextInputEditText, MaterialTextView>> = listOf()

    private var startName = ""
    private var startSurname = ""

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
            btnSave.addSystemBottomMargin()

            toolbar.setNavigationOnClickListener {
                hideSoftKeyboard()

                when(btnSave.isEnabled) {
                    true -> saveData(
                        onDismiss = {
                            navigateUp()
                        },
                        action = {
                            navigateUp()
                        }
                    )
                    false -> {
                        navigateUp()
                    }
                }
            }

            etName.setText(args.name)
            etSurname.setText(args.surname)

            startName = args.name
            startSurname = args.surname

            btnSave.isEnabled = false

            listOf(
                etName to tvEtNameLabel,
                etSurname to tvEtSurnameLabel
            ).also {
                fields = it
            }.forEach { et ->
                et.first.setOnFocusChangeListener { v, hasFocus ->
                    et.setActiveField(hasFocus)

                    if (hasFocus) {
                        v.showSoftKeyboard()
                    }
                }

                et.first.addTextChangedListener {
                    btnSave.isEnabled =
                        (etName.text?.isNotEmpty() == true && etSurname.text?.isNotEmpty() == true)
                                && (etName.text.toString() != startName || etSurname.text.toString() != startSurname)
                }
            }

            fields[0].setActiveField()
            fields[1].setActiveField()

            btnSave.setOnClickListener {
                hideSoftKeyboard()

                saveData {
                    startName = etName.text.toString()
                    startSurname = etSurname.text.toString()
                    btnSave.isEnabled = false
                }
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
            val surname = etSurname.text.toString()

            presenter.deleteUser(id, name, surname)
        }
    }

    private fun saveData(onDismiss: () -> Unit = {}, action: () -> Unit = {}) {
        SaveUserDialog(
            onClick = {
                val id = args.id
                val name = binding?.etName?.text.toString()
                val surname = binding?.etSurname?.text.toString()

                presenter.updateUser(id, name, surname, action)
            },
            onDismiss = onDismiss
        ).show(childFragmentManager, "TAG")
    }

    private fun Pair<TextInputEditText, MaterialTextView>.setActiveField(active: Boolean = true) {
        when (active) {
            true -> {
                first.setPadding(
                    (16).dpToPx(resources.displayMetrics.density),
                    (15).dpToPx(resources.displayMetrics.density),
                    0,
                    0
                )
                first.hint = ""
                second.visible()
            }
            false -> {
                if (first.text?.isEmpty() == true) {
                    first.setPadding(
                        (16).dpToPx(resources.displayMetrics.density),
                        0,
                        0,
                        0
                    )
                    second.gone()
                }
                first.hint = second.text
            }
        }
    }
}