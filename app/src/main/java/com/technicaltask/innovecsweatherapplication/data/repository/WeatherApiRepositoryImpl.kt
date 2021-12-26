package com.technicaltask.innovecsweatherapplication.data.repository

import com.technicaltask.innovecsweatherapplication.data.local.WeatherBaseDatabaseDataSource
import com.technicaltask.innovecsweatherapplication.data.network.WeatherNetworkDatabaseDataSource
import com.technicaltask.innovecsweatherapplication.domain.CityWeatherData
import com.technicaltask.innovecsweatherapplication.domain.WeatherRepository

class WeatherApiRepositoryImpl(
    private val networkDatabaseDataSource: WeatherNetworkDatabaseDataSource,
    private val databaseDataSource: WeatherBaseDatabaseDataSource
) : WeatherRepository {

    override suspend fun getWeather(queryMap: HashMap<String, String>, key: String): CityWeatherData {

        if (databaseDataSource.getCity(key) == null){
            val remoteCityData = networkDatabaseDataSource.getWeather(queryMap, key)
            databaseDataSource.saveCity(remoteCityData, key)
            return remoteCityData
        }
       return databaseDataSource.getCity(key)!!
    }

    override suspend fun clearData() {
        databaseDataSource.clear()
    }
}