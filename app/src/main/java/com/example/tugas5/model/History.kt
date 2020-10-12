package com.example.tugas5.model

data class History(
    var invoiceNumber: String,
    var date: String,
    var price: Int,
    var status: Status
)

enum class Status {
    SUCCESS,
    WAITINGPAYMENT,
    FAILED
}