package com.technicaltask.innovecsweatherapplication.data.local

import com.technicaltask.innovecsweatherapplication.data.local.room.dao.CityListDao
import com.technicaltask.innovecsweatherapplication.data.local.room.dao.RoomCityData
import com.technicaltask.innovecsweatherapplication.domain.CityWeatherData

class WeatherBaseDatabaseDataSourceImpl(private val cityListDao: CityListDao) :
    WeatherBaseDatabaseDataSource {

    override suspend fun getCity(key: String): CityWeatherData? {
        val databaseObject = cityListDao.getCityByKey(key)
        return if (databaseObject == null){
            null
        } else CityWeatherMapper.to(databaseObject)
    }

    override suspend fun saveCity(city: CityWeatherData, key: String) {
        cityListDao.insert(CityWeatherMapper.from(city, key))
    }

    override suspend fun clear() {
        cityListDao.deleteAll()
    }

    object CityWeatherMapper {
        fun to(form: RoomCityData) =
            CityWeatherData(
                form.name,
                form.temp,
                form.temp_max,
                form.temp_min,
                form.wind_speed,
                form.feels_like,
                form.description,
                form.icon
            )

        fun from(form: CityWeatherData, key: String) =
            RoomCityData(
                key,
                form.name,
                form.temp,
                form.temp_max,
                form.temp_min,
                form.wind_speed,
                form.feels_like,
                form.description,
                form.icon
            )
    }

}