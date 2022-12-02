package com.skillbox.aslanbolurov.weatherapp.domain

import com.skillbox.aslanbolurov.weatherapp.data.PersistantStorage
import javax.inject.Inject

class LastSearchUseCase @Inject constructor(
    private val persistantStorage: PersistantStorage
) {
    fun get(name:String):String?{
        return persistantStorage.getProperty(name)
    }
    fun set(name:String,value:String){
        persistantStorage.addProperty(name,value)
    }
}