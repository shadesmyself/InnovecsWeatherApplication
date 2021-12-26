package com.technicaltask.innovecsweatherapplication.base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.technicaltask.innovecsweatherapplication.data.local.room.dao.RoomCityData
import com.technicaltask.innovecsweatherapplication.data.local.room.dao.CityListDao

@Database(entities = [RoomCityData::class], version = 1, exportSchema = false)
abstract class CityListDatabase: RoomDatabase() {

    abstract fun cityListDao(): CityListDao

}