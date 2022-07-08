package com.sector.usersystem.ui.dialogs

import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sector.usersystem.databinding.BottomSheetDeleteUserBinding
import com.sector.usersystem.extensions.setWhiteNavigationBar

class DeleteUserDialog(
    private val onClick: () -> Unit
): BottomSheetDialogFragment() {

    private var binding: BottomSheetDeleteUserBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSheetDeleteUserBinding.inflate(layoutInflater)

        return binding?.rootView
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)

        dialog.apply {
            setOnShowListener {
                //Делает навбар белым
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
                    dialog.setWhiteNavigationBar()
                }
            }
        }

        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            btnDelete.setOnClickListener {
                onClick.invoke()
                dismiss()
            }
        }
    }
}