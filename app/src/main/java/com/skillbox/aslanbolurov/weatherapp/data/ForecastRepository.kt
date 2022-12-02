package com.skillbox.aslanbolurov.weatherapp.data


import com.skillbox.aslanbolurov.weatherapp.data.forecast_data_class.ForecastResponse
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ForecastRepository @Inject constructor(
    private val apiRepository: ApiRepository,
    private val databaseRepository: DatabaseRepository
) {

    suspend fun getForecast(city:String,days: Int):DBForecast? {
        try {
            val forecastResponse: ForecastResponse = apiRepository.getForecast(city,days)
            forecastResponse?.let {
                val dbForecast = DBForecast(forecastResponse.location!!.name!!,
                    forecastResponse.location!!.localtime!!,
                    forecastResponse.forecast!!
                )
                databaseRepository.db.forecastDao().insertNDelete(dbForecast)
                return dbForecast
            }
        }
        catch (e:Throwable){}
        val forecastFromDB = getForecastSaved(city)
        return forecastFromDB?:null
    }

    fun getForecastsSavedList(): List<DBForecast> {

        return databaseRepository.db.forecastDao().getAll()
    }
    fun getForecastsCitiesSavedList(): List<String> {

        return databaseRepository.db.forecastDao().getAllCities()
    }

    suspend fun getForecastSaved(city: String): DBForecast {
        return databaseRepository.db.forecastDao().getForecast(city)
    }
}
