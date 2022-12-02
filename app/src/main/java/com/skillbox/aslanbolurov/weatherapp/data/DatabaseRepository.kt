package com.skillbox.aslanbolurov.weatherapp.data

import android.content.Context
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.skillbox.aslanbolurov.weatherapp.data.util.Converters
import com.skillbox.aslanbolurov.weatherapp.data.util.GsonParser
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseRepository @Inject constructor(
    @ApplicationContext appContext: Context
) {
    private val gson = GsonBuilder().setLenient().create()
    lateinit var db: AppDataBase

    init {
        db = Room.databaseBuilder(
            appContext,
            AppDataBase::class.java,
            "db"
        ).addTypeConverter(Converters(GsonParser(gson))).allowMainThreadQueries().build()

    }

}

