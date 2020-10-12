package com.example.tugas5.data.service

import com.example.tugas5.model.Movie

//class ApiResponse(
//    private var listMovies: List<Movie>? = null,
//    private var error: Throwable? = null
//) {
//
//    fun getListMovies(): List<Movie>? {
//        return listMovies
//    }
//
//    fun setListMovies(listMovies: List<Movie>) {
//        this.listMovies = listMovies
//    }
//
//    fun getError(): Throwable? {
//        return error
//    }
//
//    fun setError(error: Throwable?) {
//        this.error = error
//    }
//
//}

data class ApiResponse(
    var listMovies: List<Movie>? = null,
    var error: Throwable? = null
)