package com.technicaltask.innovecsweatherapplication.di.module

import com.technicaltask.innovecsweatherapplication.domain.DeleteWeatherDataUseCase
import com.technicaltask.innovecsweatherapplication.domain.GetWeatherByCityNameUseCase
import com.technicaltask.innovecsweatherapplication.domain.GetWeatherByLocationUseCase
import com.technicaltask.innovecsweatherapplication.ui.weather.vm.MainFragmentViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideMainFragmentViewModel(getWeatherByCityUseCaseFactory: GetWeatherByCityNameUseCase ,getWeatherByLocationUseCase: GetWeatherByLocationUseCase, deleteWeatherDataUseCase: DeleteWeatherDataUseCase): MainFragmentViewModel {
        return MainFragmentViewModel(getWeatherByCityUseCaseFactory, getWeatherByLocationUseCase, deleteWeatherDataUseCase)
    }
}