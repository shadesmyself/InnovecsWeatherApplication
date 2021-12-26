package com.technicaltask.innovecsweatherapplication.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(private val application: Application) {
    @Provides
    fun provideApplicationContext(): Context = application
}