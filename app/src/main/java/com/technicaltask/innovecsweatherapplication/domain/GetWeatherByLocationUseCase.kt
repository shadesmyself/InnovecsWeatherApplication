package com.technicaltask.innovecsweatherapplication.domain

import com.technicaltask.innovecsweatherapplication.utils.Constants

class GetWeatherByLocationUseCase(private val repository: WeatherRepository) {

    suspend operator fun invoke(latitude: Double, longitude: Double): CityWeatherData {
        val queryMap = hashMapOf<String, String>()
        queryMap["appid"] = Constants.API_KEY
        queryMap["lat"] = latitude.toString()
        queryMap["lon"] = longitude.toString()
        queryMap["units"] = "metric"

        return repository.getWeather(queryMap, CURRENT_LOCATION_KEY)
    }

    companion object {
        private const val CURRENT_LOCATION_KEY = "CURRENT_LOCATION_KEY"
    }
}