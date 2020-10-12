package com.example.tugas5.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tugas5.di.Injection
import com.example.tugas5.repository.Repository
import com.example.tugas5.ui.address.AddressViewModel
import com.example.tugas5.ui.cart.CartViewModel
import com.example.tugas5.ui.detail.DetailViewModel
import com.example.tugas5.ui.history.HistoryViewModel
import com.example.tugas5.ui.invoice.InvoiceViewModel
import com.example.tugas5.ui.product.ProductViewModel

class ViewModelFactory private constructor(private val repository: Repository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context) : ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.providerRepository(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ProductViewModel::class.java) -> {
                ProductViewModel(repository) as T
            }
            modelClass.isAssignableFrom(HistoryViewModel::class.java) -> {
                HistoryViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CartViewModel::class.java) -> {
                CartViewModel(repository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(repository) as T
            }
            modelClass.isAssignableFrom(AddressViewModel::class.java) -> {
                AddressViewModel(repository) as T
            }
            modelClass.isAssignableFrom(InvoiceViewModel::class.java) -> {
                InvoiceViewModel(repository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }

}