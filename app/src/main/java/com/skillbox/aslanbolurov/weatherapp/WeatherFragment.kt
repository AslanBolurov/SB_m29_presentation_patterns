package com.skillbox.aslanbolurov.weatherapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.skillbox.aslanbolurov.weatherapp.data.DBForecast
import com.skillbox.aslanbolurov.weatherapp.data.forecast_data_class.Forecastday
import com.skillbox.aslanbolurov.weatherapp.viewmodels.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment : Fragment() {

    private lateinit var dbForecast: DBForecast
    private lateinit var cityName:String
    private val viewModel: WeatherViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let {cityName = it.getString(CITY_KEY).toString() }
        if (this::cityName.isInitialized){
            viewModel.getForecast(cityName)
        }
        lifecycleScope.launchWhenStarted { viewModel.forecast.collect{
            Log.d("MyLog", "collect from fragment" + it.toString())
        } }
        return ComposeView(requireContext()).apply {
            setContent {
                ForecastsList()
            }
        }
    }
    @Composable
    fun ForecastsList() {
        val forecast by viewModel._forecast.collectAsState(initial = null)
        LazyColumn{
            forecast?.let {
                itemsIndexed(forecast!!.forecast.forecastday) { index, item ->
                    if (item != null) {
                        item(item)
                    }
                }
            }

        }
    }
    @Composable
    fun item(forecast: Forecastday){
        Text(text = forecast?.date+": "+forecast.day?.mintempC+"..."+forecast.day?.maxtempC, modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
             )
    }
    companion object{
        const val CITY_KEY = "city_key"
    }
}