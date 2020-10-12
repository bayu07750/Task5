package com.example.tugas5.ui.cart

import androidx.recyclerview.widget.RecyclerView
import com.example.tugas5.data.db.Cart
import com.example.tugas5.databinding.ItemCartBinding

class CartViewHolder(
    private val binding: ItemCartBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(cart: Cart) {
        binding.cart = cart
    }
}