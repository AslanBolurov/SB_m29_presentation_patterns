package com.skillbox.aslanbolurov.weatherapp.domain

import com.skillbox.aslanbolurov.weatherapp.data.DBForecast
import com.skillbox.aslanbolurov.weatherapp.data.ForecastRepository
import javax.inject.Inject

class GetForecastSavedListUseCase @Inject constructor(
    private val forecastRepository: ForecastRepository
) {
    suspend fun execute(): List<DBForecast> {
        return forecastRepository.getForecastsSavedList()
    }
    suspend fun executeCity(): List<String> {
        return forecastRepository.getForecastsCitiesSavedList()
    }
}