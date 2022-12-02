package com.skillbox.aslanbolurov.weatherapp.domain


import com.skillbox.aslanbolurov.weatherapp.data.DBForecast
import com.skillbox.aslanbolurov.weatherapp.data.ForecastRepository
import javax.inject.Inject

class GetForecastUseCase @Inject constructor(
    private val forecastRepository: ForecastRepository
) {
    suspend fun execute(city: String, days: Int): DBForecast? {
        return forecastRepository.getForecast(city, days)
    }
}