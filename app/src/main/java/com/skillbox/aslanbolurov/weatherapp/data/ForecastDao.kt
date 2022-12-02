package com.skillbox.aslanbolurov.weatherapp.data

import androidx.room.*

@Dao
interface ForecastDao {

    @Query("SELECT * FROM forecasts")
    fun getAll(): List<DBForecast>

    @Query("SELECT city FROM forecasts")
    fun getAllCities(): List<String>

    @Query("SELECT * FROM forecasts WHERE city LIKE '%' || :name || '%' ")
    suspend fun getForecast(name: String): DBForecast

    @Query("SELECT * FROM forecasts WHERE city LIKE '%' || :name || '%' ")
    suspend fun getForecasts(name: String): List<DBForecast>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dbForecast: DBForecast)

    suspend fun insertNDelete(dbForecast: DBForecast) {
        deleteByName(dbForecast.city)
        insert(dbForecast)

    }

    @Query("DELETE FROM forecasts WHERE city LIKE :city")
    suspend fun deleteByName(city: String)

    @Delete
    suspend fun delete(dbForecast: DBForecast)

    @Query("DELETE FROM forecasts")
    suspend fun clear()

    @Update
    suspend fun update(dbForecast: DBForecast)
}