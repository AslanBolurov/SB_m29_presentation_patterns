package com.skillbox.aslanbolurov.weatherapp.viewmodels

import androidx.lifecycle.ViewModel
import com.skillbox.aslanbolurov.weatherapp.data.DBForecast
import com.skillbox.aslanbolurov.weatherapp.domain.GetForecastUseCase
import com.skillbox.aslanbolurov.weatherapp.domain.LastSearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getForecastUseCase: GetForecastUseCase,
    private val lastSearchUseCase: LastSearchUseCase
):ViewModel() {
    suspend fun getForecast(city:String,days:Int): DBForecast?{
        return getForecastUseCase.execute(city.trim(),days)
    }
    fun getLastSearch(name:String):String?{
        return lastSearchUseCase.get(name)
    }
    fun setLastSearch(name:String,value:String){
        lastSearchUseCase.set(name,value)
    }
}