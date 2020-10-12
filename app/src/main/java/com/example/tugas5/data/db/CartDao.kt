package com.example.tugas5.data.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CartDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCart(cart: Cart)

    @Delete
    suspend fun deleteFromCart(cart: Cart)

    @Update
    suspend fun updateCurrentCart(cart: Cart)

    @Query("SELECT * FROM cart_table ORDER BY id DESC")
    fun readCart(): LiveData<List<Cart>>
    
    @Query("SELECT * FROM cart_table WHERE title LIKE :query")
    fun searchCart(query: String): LiveData<List<Cart>>

}