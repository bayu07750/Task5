package com.example.tugas5.di

import android.content.Context
import com.example.tugas5.data.db.CartDatabase
import com.example.tugas5.repository.Repository
import com.example.tugas5.data.service.ApiEndpoints
import com.example.tugas5.data.service.ApiService

object Injection {

    fun providerRepository(context: Context): Repository {
        val retrofitService = ApiService.getService()
        val apiEndpoints = retrofitService.create(ApiEndpoints::class.java)
        val cartDatabase = CartDatabase.getDatabase(context)
        val cartDao = cartDatabase.cartDao()
        return Repository(cartDao, apiEndpoints)
    }

}