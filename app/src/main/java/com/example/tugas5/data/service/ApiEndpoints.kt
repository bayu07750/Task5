package com.example.tugas5.data.service

import com.example.tugas5.BuildConfig
import com.example.tugas5.model.Movies
import retrofit2.Call
import retrofit2.http.GET

private const val API_KEY = BuildConfig.TMDB_API_KEY

interface ApiEndpoints {

    @GET("movie/top_rated?api_key=$API_KEY&language=en-US&page=1")
    fun getMovieTopRated(): Call<Movies>

}