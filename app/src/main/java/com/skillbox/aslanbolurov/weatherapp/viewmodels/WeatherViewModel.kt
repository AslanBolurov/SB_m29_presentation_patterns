package com.skillbox.aslanbolurov.weatherapp.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skillbox.aslanbolurov.weatherapp.data.DBForecast
import com.skillbox.aslanbolurov.weatherapp.domain.GetForecastSavedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getForecastSavedUseCase: GetForecastSavedUseCase
) : ViewModel() {
    val _forecast = MutableStateFlow<DBForecast?>(null)
    val forecast = _forecast.asStateFlow()

    fun getForecast(city: String) {
        Log.d("MyLog", "getForecastSavedUseCase" + getForecastSavedUseCase.toString())
        viewModelScope.launch {
            _forecast.value = getForecastSavedUseCase.execute(city.replace(" ", ""))
            Log.d("MyLog", "_forecast.value" + getForecastSavedUseCase.execute(city).toString())
        }
    }
}