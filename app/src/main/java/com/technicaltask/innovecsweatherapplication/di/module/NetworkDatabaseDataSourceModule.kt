package com.technicaltask.innovecsweatherapplication.di.module

import com.technicaltask.innovecsweatherapplication.base.CityListDatabase
import com.technicaltask.innovecsweatherapplication.data.local.WeatherBaseDatabaseDataSource
import com.technicaltask.innovecsweatherapplication.data.local.WeatherBaseDatabaseDataSourceImpl
import com.technicaltask.innovecsweatherapplication.data.network.WeatherNetworkDatabaseDataSource
import com.technicaltask.innovecsweatherapplication.data.network.WeatherNetworkDatabaseDataSourceImpl
import com.technicaltask.innovecsweatherapplication.data.remote.OpenWeatherApi
import dagger.Module
import dagger.Provides

@Module
class NetworkDatabaseDataSourceModule {
    @Provides
    fun provideWeatherNetworkDatabaseDataSource(retrofit : OpenWeatherApi): WeatherNetworkDatabaseDataSource {
        return WeatherNetworkDatabaseDataSourceImpl(retrofit)
    }

    @Provides
    fun provideWeatherBaseDatabaseDataSource(roomDatabase: CityListDatabase): WeatherBaseDatabaseDataSource =
        WeatherBaseDatabaseDataSourceImpl(roomDatabase.cityListDao())
}