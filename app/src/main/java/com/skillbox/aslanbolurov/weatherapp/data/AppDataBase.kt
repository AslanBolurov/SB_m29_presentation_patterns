package com.skillbox.aslanbolurov.weatherapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.skillbox.aslanbolurov.weatherapp.data.util.Converters

@TypeConverters(Converters::class)
@Database(entities = [DBForecast::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun forecastDao():ForecastDao
}