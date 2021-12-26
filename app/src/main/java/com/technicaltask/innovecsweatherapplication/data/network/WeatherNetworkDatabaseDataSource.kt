package com.technicaltask.innovecsweatherapplication.data.network

import com.technicaltask.innovecsweatherapplication.data.dto.BaseResponse
import com.technicaltask.innovecsweatherapplication.data.dto.Coord
import com.technicaltask.innovecsweatherapplication.data.dto.DataWrapperResponse
import com.technicaltask.innovecsweatherapplication.domain.CityWeatherData
import retrofit2.Response

interface WeatherNetworkDatabaseDataSource {
    suspend fun getWeather(queryMap: HashMap<String, String>, key: String): CityWeatherData

}