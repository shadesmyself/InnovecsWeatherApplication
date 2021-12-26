package com.technicaltask.innovecsweatherapplication.domain

import com.technicaltask.innovecsweatherapplication.utils.Constants

class GetWeatherByCityNameUseCase(private val repository: WeatherRepository) {

    suspend operator fun invoke (cityName: String): CityWeatherData{
         val queryMap = hashMapOf<String, String>()
        queryMap["appid"] = Constants.API_KEY
        queryMap["q"] = cityName
        queryMap["units"] = "metric"

        return repository.getWeather(queryMap, cityName)
    }
}