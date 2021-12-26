package com.technicaltask.innovecsweatherapplication.domain

data class CityWeatherData(
    val name: String,
    val temp: Double,
    val temp_max: Double,
    val temp_min: Double,
    val wind_speed: Double,
    val feels_like: Double,
    val description: String,
    val icon: String
)

