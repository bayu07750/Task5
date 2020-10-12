package com.example.tugas5.ui.address

import androidx.recyclerview.widget.RecyclerView
import com.example.tugas5.databinding.ItemPembayaranBinding
import com.example.tugas5.model.Payment

class AddressViewHolder(
    private val binding: ItemPembayaranBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(payment: Payment) {
        binding.payment = payment
    }
}