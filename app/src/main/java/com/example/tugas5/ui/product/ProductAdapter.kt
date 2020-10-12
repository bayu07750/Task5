package com.example.tugas5.ui.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas5.databinding.ItemMovieBinding
import com.example.tugas5.model.Movie

class ProductAdapter : RecyclerView.Adapter<ProductViewHolder>() {

    private var list = emptyList<Movie>()
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setData(list: List<Movie>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(inflater, parent, false)
        return ProductViewHolder(binding, onItemClickCallback)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickCallback {
        fun onItemClicked(movie: Movie)
    }
}