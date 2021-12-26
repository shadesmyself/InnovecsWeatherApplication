package com.technicaltask.innovecsweatherapplication.domain

class DeleteWeatherDataUseCase(private val repository: WeatherRepository) {

    suspend operator fun invoke () {
        repository.clearData()
    }
}