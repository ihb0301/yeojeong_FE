package com.example.yeojeong.Retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface DirectionApiInterface {
    @GET
    fun getDirection(
        @Url url: String,
        @Query("origin") origin: String,
        @Query("destination") destination: String,
        @Query("key") key: String,
        @Query("mode") mode: String
    ): Call<DirectionApiModel>
}