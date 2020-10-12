package com.example.tugas5.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugas5.data.db.Cart
import com.example.tugas5.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: Repository) : ViewModel() {

    fun addCart(cart: Cart) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCart(cart)
        }
    }

}