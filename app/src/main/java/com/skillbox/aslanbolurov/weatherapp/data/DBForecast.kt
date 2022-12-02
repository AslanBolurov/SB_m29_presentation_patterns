package com.skillbox.aslanbolurov.weatherapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import com.skillbox.aslanbolurov.weatherapp.data.forecast_data_class.Forecast

@Entity(tableName = "forecasts", primaryKeys = ["city", "upload_date"])

data class DBForecast(
    @ColumnInfo(name = "city")
    @SerializedName("city")
    val city: String,

    @ColumnInfo(name = "upload_date")
    @SerializedName("upload_date")
    val upload_date: String,

    @ColumnInfo(name = "forecast")
    @SerializedName("forecast")
    val forecast: Forecast
)

