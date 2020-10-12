package com.example.tugas5.model


import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("page")
    var page: Int? = null,
    @SerializedName("results")
    var listMovies: List<Movie>? = null,
    @SerializedName("total_pages")
    var totalPages: Int? = null,
    @SerializedName("total_results")
    var totalResults: Int? = null
)