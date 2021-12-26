package com.technicaltask.innovecsweatherapplication.domain

interface WeatherRepository {

    suspend fun getWeather(queryMap: HashMap<String, String>, key: String): CityWeatherData
    suspend fun clearData()
}