package com.technicaltask.innovecsweatherapplication.di.components

import android.content.Context
import com.technicaltask.innovecsweatherapplication.di.module.*
import com.technicaltask.innovecsweatherapplication.ui.weather.ui.MainFragment
import dagger.Component

@Component(modules = [ContextModule::class ,NetworkDatabaseDataSourceModule::class, RepositoryModule::class, UseCaseModule::class, ViewModelModule::class, RoomModule::class, RetrofitModule::class])

interface AppComponent {
    fun context(): Context
    fun inject(fragment: MainFragment)
}