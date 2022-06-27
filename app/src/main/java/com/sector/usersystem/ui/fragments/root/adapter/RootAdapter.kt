package com.sector.usersystem.ui.fragments.root.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.sector.usersystem.databinding.ItemUserBinding
import com.sector.usersystem.extensions.binding
import com.sector.usersystem.model.data.local.RecyclerViewType
import com.sector.usersystem.ui.common.adapter.BaseViewHolder

class RootAdapter(
    private val onClick: (UserItem) -> Unit
): AdapterDelegate<MutableList<RecyclerViewType>>() {
    override fun isForViewType(items: MutableList<RecyclerViewType>, position: Int): Boolean =
        items[position].getViewType() == 0

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        ViewHolder(parent)

    override fun onBindViewHolder(
        items: MutableList<RecyclerViewType>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        holder as ViewHolder
        holder.bind(items[position], position, items.count())
    }

    inner class ViewHolder(
        parent: ViewGroup
    ): BaseViewHolder<ItemUserBinding>(
        parent.binding(ItemUserBinding::inflate)
    ) {
        fun bind(item: RecyclerViewType, position: Int, count: Int) {
            item as UserItem

            binding.apply {
                tvName.text = item.name
            }
        }
    }
}



class UserItem(
    val name: String = "name"
): RecyclerViewType {
    override fun getViewType(): Int = 0

}