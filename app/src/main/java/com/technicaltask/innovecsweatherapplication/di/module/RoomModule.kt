package com.technicaltask.innovecsweatherapplication.di.module

import android.content.Context
import androidx.room.Room
import com.technicaltask.innovecsweatherapplication.base.CityListDatabase
import dagger.Module
import dagger.Provides

@Module
class RoomModule {
    @Provides
    fun provideDatabase(context: Context) =
        Room.databaseBuilder(context, CityListDatabase::class.java, "city_name_database").build()
}