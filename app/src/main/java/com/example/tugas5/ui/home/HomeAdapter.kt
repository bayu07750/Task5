package com.example.tugas5.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas5.databinding.ItemHomeBinding

class HomeAdapter : RecyclerView.Adapter<HomeViewHolder>() {
    
    private var listMenu = emptyList<String>()
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    
    fun setData(listMenu: List<String>) {
        this.listMenu = listMenu
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHomeBinding.inflate(inflater, parent, false)
        return HomeViewHolder(binding, onItemClickCallback)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(listMenu[position])
    }

    override fun getItemCount(): Int = listMenu.size

    interface OnItemClickCallback {
        fun onItemClick(textMenu: String, position: Int)
    }
}