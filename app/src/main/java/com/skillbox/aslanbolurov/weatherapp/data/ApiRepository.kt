package com.skillbox.aslanbolurov.weatherapp.data

import com.google.gson.GsonBuilder
import com.skillbox.aslanbolurov.weatherapp.data.forecast_data_class.ForecastResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepository @Inject constructor() {
    object RetrofitServices{
        private const val BASE_URL= "https://api.weatherapi.com/v1/"
        private val gson = GsonBuilder().setLenient().create()
        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val forecastApi:ForecastApi = retrofit.create(
            ForecastApi::class.java
        )

        interface ForecastApi{
            @GET("forecast.json")
            suspend fun getForecast(@Query("key") key:String, @Query("q") q:String, @Query("days") days:Int, @Query("aqi") aqi:String, @Query("alerts") alerts:String): ForecastResponse
        }

    }


    suspend fun getForecast(city:String,days: Int): ForecastResponse {
        return RetrofitServices.forecastApi.getForecast("729410d95e844686bf082657222511",city,days,"no","no")
    }
}