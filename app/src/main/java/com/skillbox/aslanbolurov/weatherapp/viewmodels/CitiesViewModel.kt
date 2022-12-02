package com.skillbox.aslanbolurov.weatherapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skillbox.aslanbolurov.weatherapp.domain.GetForecastSavedListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(
    private val getForecastSavedListUseCase: GetForecastSavedListUseCase
):ViewModel() {
    private val _cityNames = MutableStateFlow<MutableList<String>>(mutableListOf())
    val cityNames = _cityNames.asStateFlow()
    fun getForecasts(){
        viewModelScope.launch {
            _cityNames.value = getForecastSavedListUseCase.executeCity().toMutableList()
        }
    }
}