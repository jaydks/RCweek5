package com.example.rcweek5


import com.squareup.moshi.Json

data class MovieResponse(
    @Json(name = "boxOfficeResult")
    val boxOfficeResult: BoxOfficeResult?
)