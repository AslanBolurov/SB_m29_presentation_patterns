package com.skillbox.aslanbolurov.weatherapp.data.util

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.skillbox.aslanbolurov.weatherapp.data.forecast_data_class.Forecast

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun toMeaningJson(forecast: Forecast) : String {
        return jsonParser.toJson(
            forecast,
            Forecast::class.java
        ) ?: "[]"
    }

    @TypeConverter
    fun fromMeaningsJson(json: String): Forecast{
        return jsonParser.fromJson<Forecast>(
            json,
            Forecast::class.java
        ) ?: Forecast()
    }
}