package com.example.tugas5.ui.product

import androidx.recyclerview.widget.RecyclerView
import com.example.tugas5.databinding.ItemMovieBinding
import com.example.tugas5.model.Movie

class ProductViewHolder(
    private val binding: ItemMovieBinding,
    private val onItemClickCallback: ProductAdapter.OnItemClickCallback?
): RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie) {
        binding.movie = movie
        if (onItemClickCallback != null) {
            binding.root.setOnClickListener { onItemClickCallback.onItemClicked(movie) }
        }
    }
}