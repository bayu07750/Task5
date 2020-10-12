package com.example.tugas5.data.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "cart_table")
data class Cart(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var image: String,
    var title: String,
    var price: Int,
    var pts: Int
): Parcelable