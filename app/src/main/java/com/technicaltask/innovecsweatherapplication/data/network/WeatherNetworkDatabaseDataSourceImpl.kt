package com.technicaltask.innovecsweatherapplication.data.network

import com.technicaltask.innovecsweatherapplication.data.dto.BaseResponse
import com.technicaltask.innovecsweatherapplication.data.remote.OpenWeatherApi
import com.technicaltask.innovecsweatherapplication.domain.CityWeatherData
import java.io.IOException

import javax.inject.Inject

class WeatherNetworkDatabaseDataSourceImpl @Inject constructor( private val openWeatherApi: OpenWeatherApi): WeatherNetworkDatabaseDataSource {

    override suspend fun getWeather(queryMap: HashMap<String, String>, key: String): CityWeatherData {
        val response = openWeatherApi.getWeather(queryMap)
        val body = response.body()
        if (body?.cod == 200) {
            return ModelMapper.from(body)
        } else {
            throw IOException()
        }

    }
    object ModelMapper {
        fun from(form: BaseResponse) =
            CityWeatherData(form.name , form.main.temp, form.main.temp_max, form.main.temp_min, form.wind.speed, form.main.feels_like, form.weather[0].description, form.weather[0].icon)
    }

}