package com.example.tugas5.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugas5.data.db.Cart
import com.example.tugas5.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel(private val repository: Repository) : ViewModel() {

    var readCart: LiveData<List<Cart>> = repository.readCart()

    fun deleteFromCart(cart: Cart) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteFromCart(cart)
        }
    }

}