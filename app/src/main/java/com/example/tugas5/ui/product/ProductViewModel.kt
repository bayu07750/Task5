package com.example.tugas5.ui.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugas5.data.db.Cart
import com.example.tugas5.repository.Repository
import com.example.tugas5.data.service.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: Repository) : ViewModel() {

    private var mApiResponse: MediatorLiveData<ApiResponse> = MediatorLiveData()

    fun getDataListMovies(): LiveData<ApiResponse> {
        mApiResponse.addSource(repository.getListMovies()) {
            mApiResponse.value = it
        }

        return mApiResponse
    }

    fun addCart(cart: Cart) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCart(cart)
        }
    }

    fun updateCurrentCart(cart: Cart) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateCurrentCart(cart)
        }
    }

    var readCart: LiveData<List<Cart>> = repository.readCart()

}