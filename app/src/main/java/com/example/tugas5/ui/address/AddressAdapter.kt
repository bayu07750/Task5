package com.example.tugas5.ui.address

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas5.databinding.ItemPembayaranBinding
import com.example.tugas5.model.Payment

class AddressAdapter : RecyclerView.Adapter<AddressViewHolder>() {

    private var list = emptyList<Payment>()

    fun setData(list: List<Payment>) {
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPembayaranBinding.inflate(inflater, parent, false)
        return AddressViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}