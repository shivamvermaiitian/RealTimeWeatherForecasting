package com.example.realtimeweather.ui.theme

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("current.json")
    suspend fun getWeather(
        @Query("key") apiKey:String,
        @Query("q") location:String,
    ):WeatherResponse
}

object WeatherApi {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val weatherService:WeatherService= retrofit.create(WeatherService::class.java)
}