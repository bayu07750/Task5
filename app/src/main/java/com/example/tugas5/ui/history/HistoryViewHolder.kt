package com.example.tugas5.ui.history

import androidx.recyclerview.widget.RecyclerView
import com.example.tugas5.databinding.ItemHistoryBinding
import com.example.tugas5.model.History

class HistoryViewHolder(private val binding: ItemHistoryBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(history: History) {
        binding.history = history
    }
}