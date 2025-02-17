package com.example.yeojeong.ApplicationClass

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Yeojeong: Application() {
    companion object {
        //ToDo. 서버 주소 변경 필요
        val url: String = "https://maps.googleapis.com/maps/api/directions/json/";
        val retrofit: Retrofit
            get() = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build()
    }
}