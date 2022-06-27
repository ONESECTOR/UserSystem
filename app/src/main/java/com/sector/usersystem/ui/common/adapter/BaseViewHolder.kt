package com.sector.usersystem.ui.common.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

open class BaseViewHolder<T : ViewBinding>(
    val binding: T
) : RecyclerView.ViewHolder(binding.root)