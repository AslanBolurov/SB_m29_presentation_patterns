package com.skillbox.aslanbolurov.weatherapp.data.forecast_data_class

import com.google.gson.annotations.SerializedName


data class Forecast(

    @SerializedName("forecastday") var forecastday: ArrayList<Forecastday> = arrayListOf()

)