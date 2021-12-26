package com.technicaltask.innovecsweatherapplication.di.module

import com.technicaltask.innovecsweatherapplication.data.local.WeatherBaseDatabaseDataSource
import com.technicaltask.innovecsweatherapplication.data.network.WeatherNetworkDatabaseDataSource
import com.technicaltask.innovecsweatherapplication.domain.WeatherRepository
import com.technicaltask.innovecsweatherapplication.data.repository.WeatherApiRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideWeatherRepository(
        networkDatabaseDataSource: WeatherNetworkDatabaseDataSource,
        baseDatabaseDataSource: WeatherBaseDatabaseDataSource
    ): WeatherRepository {
        return WeatherApiRepositoryImpl(networkDatabaseDataSource, baseDatabaseDataSource)
    }
}