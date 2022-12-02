package com.skillbox.aslanbolurov.weatherapp.data.forecast_data_class

import com.google.gson.annotations.SerializedName
import com.skillbox.aslanbolurov.weatherapp.data.forecast_data_classes.Astro


data class Forecastday(

    @SerializedName("date") var date: String? = null,
    @SerializedName("date_epoch") var dateEpoch: Int? = null,
    @SerializedName("day") var day: Day? = Day(),
    @SerializedName("astro") var astro: Astro? = Astro(),
    @SerializedName("hour") var hour: ArrayList<Hour> = arrayListOf()

)