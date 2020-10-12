package com.example.tugas5.ui.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tugas5.model.History
import com.example.tugas5.model.Status
import com.example.tugas5.repository.Repository

class HistoryViewModel(private val repository: Repository) : ViewModel() {

    private var mutablelist = MutableLiveData<List<History>>()
    var data: ArrayList<History> = ArrayList()

    fun setDataHistory() {
        data.addAll(listOf(
            History("SP7783ACD", "3 September 2016", 1050000, Status.WAITINGPAYMENT),
            History("SP7783ACD", "3 Oktober 2018", 1000000, Status.SUCCESS),
            History("SP7983ACD", "5 Oktober 2018", 1500000, Status.SUCCESS)
        ))
        mutablelist.value = data
    }

    fun getDataHistory(): LiveData<List<History>> =  mutablelist

    fun deleteDataWithPosition(position: Int) {
        data.removeAt(position)
    }

    fun addDataHistory(history: History) {
        data.add(history)
    }
}