package com.example.tugas5.utils

import android.content.Context
import android.util.Patterns
import com.example.tugas5.R
import com.google.android.material.textfield.TextInputLayout

fun validateEmail(view: TextInputLayout, context: Context): Boolean {
    val emailInput = view.editText?.text.toString().trim()
    return if (emailInput.isEmpty()) {
        view.error = context.getString(R.string.messageEmpty)
        false
    } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
        view.error = context.getString(R.string.messageEmailValid)
        false
    } else {
        view.error = null
        true
    }
}

fun validatePassword(view: TextInputLayout, context: Context): Boolean {
    val passwordInput = view.editText?.text.toString().trim()
    return if (passwordInput.isEmpty()) {
        view.error = context.getString(R.string.messageEmpty)
        false
    } else if (passwordInput.length < 8) {
        view.error = context.getString(R.string.messagePasswordMoreThan)
        false
    } else {
        view.error = null
        true
    }
}

fun validateRetypePassword(view1 : TextInputLayout, view2: TextInputLayout, context: Context): Boolean {
    val passwordInput = view1.editText?.text.toString().trim()
    val passwordRetypeInput = view2.editText?.text.toString().trim()
    return if (passwordInput != passwordRetypeInput) {
        view2.error = context.getString(R.string.messagePasswordIsNotSame)
        false
    } else {
        view2.error = null
        true
    }
}

fun validateOther(view: TextInputLayout, context: Context): Boolean {
    val otherInput = view.editText?.text.toString()
    return if (otherInput.isEmpty()) {
        view.error = context.getString(R.string.messageEmpty)
        false
    } else {
        view.error = null
        true
    }
}