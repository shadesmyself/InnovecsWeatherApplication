package com.technicaltask.innovecsweatherapplication.di.module

import com.technicaltask.innovecsweatherapplication.domain.DeleteWeatherDataUseCase
import com.technicaltask.innovecsweatherapplication.domain.GetWeatherByCityNameUseCase
import com.technicaltask.innovecsweatherapplication.domain.GetWeatherByLocationUseCase
import com.technicaltask.innovecsweatherapplication.domain.WeatherRepository
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetWeatherByCityUseCase(repository: WeatherRepository): GetWeatherByCityNameUseCase {
        return GetWeatherByCityNameUseCase(repository)
    }

    @Provides
    fun provideGetWeatherByLocationUseCase(repository : WeatherRepository): GetWeatherByLocationUseCase {
        return GetWeatherByLocationUseCase(repository)
    }
    @Provides
    fun provideDeleteWeatherLocalDataUseCase(repository : WeatherRepository): DeleteWeatherDataUseCase {
        return DeleteWeatherDataUseCase(repository)
    }

}