package com.skillbox.aslanbolurov.weatherapp.data

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PersistantStorage @Inject constructor(
    @ApplicationContext context: Context
) {

    private var sharedPreferences: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null
    private var context: Context = context

    private fun init() {
        sharedPreferences = context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences!!.edit()
    }

    fun addProperty(name: String?, value: String?) {
        if (sharedPreferences == null) {
            init()
        }
        editor!!.putString(name, value)
        editor!!.apply()
    }

    fun getProperty(name: String?): String? {
        if (sharedPreferences == null) {
            init()
        }
        return sharedPreferences!!.getString(name, null)
    }

    companion object {
        const val STORAGE_NAME = "StorageName"
        const val LAST_SEARCH = "lastsearch"
    }
}