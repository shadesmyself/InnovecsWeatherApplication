package com.technicaltask.innovecsweatherapplication

import android.app.Application
import androidx.annotation.Keep
import com.technicaltask.innovecsweatherapplication.di.components.AppComponent
import com.technicaltask.innovecsweatherapplication.di.components.DaggerAppComponent
import com.technicaltask.innovecsweatherapplication.di.module.ContextModule

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
        // TODO() создать use case и удалить данные из room
    }

    @Keep
    companion object{
        lateinit var appComponent: AppComponent
        const val OPEN_WEATHER_URL = "https://api.openweathermap.org/"
    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .build()
    }

}