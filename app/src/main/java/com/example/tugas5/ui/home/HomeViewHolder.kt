package com.example.tugas5.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.example.tugas5.databinding.ItemHomeBinding

class HomeViewHolder(
    private val binding: ItemHomeBinding,
    private val onItemClickCallback: HomeAdapter.OnItemClickCallback?
): RecyclerView.ViewHolder(binding.root) {
    fun bind(textMenu: String) {
        binding.textMenu.text = textMenu
        if (onItemClickCallback != null) {
            binding.mainCard.setOnClickListener { onItemClickCallback.onItemClick(textMenu, adapterPosition) }
        }
    }
}