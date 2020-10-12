package com.example.tugas5.ui.address

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tugas5.model.Payment
import com.example.tugas5.repository.Repository

class AddressViewModel(private val repository: Repository): ViewModel() {

    private var listPayment = MutableLiveData<List<Payment>>()
    var _listPayment: List<Payment> = listOf(
        Payment("BCA", "Rizal Mahendra", "222 29109 1209", "Banyumanik"),
        Payment("MANDIRI", "Rizal Mahendra", "1233 9023 7589", "Banyumanik")
    )

    fun getDataListPayment(): LiveData<List<Payment>> {
        listPayment.value = _listPayment
        return listPayment
    }

}