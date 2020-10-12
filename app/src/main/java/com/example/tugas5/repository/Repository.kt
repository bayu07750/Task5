package com.example.tugas5.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tugas5.data.db.Cart
import com.example.tugas5.data.db.CartDao
import com.example.tugas5.model.Movies
import com.example.tugas5.data.service.ApiEndpoints
import com.example.tugas5.data.service.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(
    private val cartDao: CartDao,
    private val apiEndpoints: ApiEndpoints
) {

    suspend fun addCart(cart: Cart) {
        cartDao.addCart(cart)
    }

    suspend fun deleteFromCart(cart: Cart) {
        cartDao.deleteFromCart(cart)
    }

    suspend fun updateCurrentCart(cart: Cart) {
        cartDao.updateCurrentCart(cart)
    }

    fun readCart(): LiveData<List<Cart>> {
        return cartDao.readCart()
    }

    fun searchCart(query: String): LiveData<List<Cart>> {
        return cartDao.searchCart(query)
    }

    fun getListMovies(): LiveData<ApiResponse> {
        val apiResponse = MutableLiveData<ApiResponse>()
        apiEndpoints.getMovieTopRated().enqueue(object : Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if (response.isSuccessful) {
                    apiResponse.value = ApiResponse(response.body()?.listMovies, null)
                    Log.d(TAG, "onResponse: Success...")
                } else {
                    Log.d(TAG, "onResponse: Failde... -> ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                apiResponse.value = ApiResponse(null, t)
            }
        })
        return apiResponse
    }

    companion object {
        private val TAG = Repository::class.java.simpleName
    }

}