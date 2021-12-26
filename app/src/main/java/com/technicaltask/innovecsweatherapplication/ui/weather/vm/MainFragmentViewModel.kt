package com.technicaltask.innovecsweatherapplication.ui.weather.vm

import androidx.lifecycle.MutableLiveData
import com.technicaltask.innovecsweatherapplication.base.BaseViewModel
import com.technicaltask.innovecsweatherapplication.domain.CityWeatherData
import com.technicaltask.innovecsweatherapplication.domain.DeleteWeatherDataUseCase
import com.technicaltask.innovecsweatherapplication.domain.GetWeatherByCityNameUseCase
import com.technicaltask.innovecsweatherapplication.domain.GetWeatherByLocationUseCase

class MainFragmentViewModel(
    private var getWeatherByCityNameUseCase: GetWeatherByCityNameUseCase,
    private val getWeatherByLocationUseCase: GetWeatherByLocationUseCase,
    private val deleteWeatherDataUseCase: DeleteWeatherDataUseCase
) : BaseViewModel() {

    val cityLiveData = MutableLiveData<List<String>>()
    val weatherCityData = MutableLiveData<CityWeatherData>()

    private var latitude: Double = 0.0
    private var longitude: Double = 0.0
    private val cityArray = arrayListOf<String>()

    init {
        cityArray.add("London")
        cityArray.add("Istanbul ")
        cityArray.add("Tokyo")
        cityArray.add("New York")
        cityArray.add("Kyiv")
        cityLiveData.postValue(cityArray)
    }

    fun setLocation(latitude: Double, longitude: Double) {
        this.latitude = latitude
        this.longitude = longitude
        val cities = cityArray.toMutableList()
        cities.add(0, "<current location>")
        cityLiveData.postValue(cities)
    }

    fun currentLocationSelect() {
        runOperation {
            work {
                val weather = getWeatherByLocationUseCase(latitude, longitude)
                weatherCityData.postValue(weather)
            }
        }
    }

    fun citySelect(city: String) {
        runOperation {
            work {
                val weather = getWeatherByCityNameUseCase(city)
                weatherCityData.postValue(weather)
            }
        }
    }

    fun deleteAllLocalData() {
        runOperation {
            work {
                deleteWeatherDataUseCase.invoke()
            }
        }
    }
}