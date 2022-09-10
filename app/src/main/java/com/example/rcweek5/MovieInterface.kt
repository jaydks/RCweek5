package com.example.rcweek5

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInterface {
    @GET("boxoffice/searchDailyBoxOfficeList.json")
    fun getMovieData(@Query("key") KEY : String,
                    @Query("targetDt") DATE : String
    ) : Call<MovieResponse>

}