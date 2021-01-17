package com.sudzu.trtlmtest.ui.main

import androidx.recyclerview.widget.DiffUtil
import com.sudzu.trtlmtest.data.model.Bug

class BugsDiffCallback(private val oldList: List<Bug>, private val newList: List<Bug>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.hashCode() == newItem.hashCode()
    }
}