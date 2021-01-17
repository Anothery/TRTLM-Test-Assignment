package com.sudzu.trtlmtest.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sudzu.trtlmtest.data.model.Bug
import com.sudzu.trtlmtest.databinding.BugItemBinding

class BugsAdapter(private val onItemClicked: (Int) -> Unit) :
    RecyclerView.Adapter<BugsAdapter.ViewHolder>() {

    private var bugs: ArrayList<Bug> = arrayListOf()

    fun setBugs(newList: List<Bug>) {
        val diffResult = DiffUtil.calculateDiff(BugsDiffCallback(bugs, newList))
        bugs.clear()
        bugs.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BugsAdapter.ViewHolder {
        val binding = BugItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BugsAdapter.ViewHolder, position: Int) =
        holder.bind(bugs[position])

    override fun getItemCount(): Int = bugs.size

    inner class ViewHolder(private val binding: BugItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(Bug: Bug) {
            binding.root.setOnClickListener { onItemClicked(Bug.id) }
            binding.tvId.text = Bug.id.toString()
            binding.tvType.text = Bug.type
            binding.tvStatus.text = Bug.status
        }
    }
}