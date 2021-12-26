package com.technicaltask.innovecsweatherapplication.data.local

import com.technicaltask.innovecsweatherapplication.domain.CityWeatherData

interface WeatherBaseDatabaseDataSource {

     suspend fun getCity(key: String): CityWeatherData?
     suspend fun saveCity(city: CityWeatherData, key: String)
     suspend fun clear()
}