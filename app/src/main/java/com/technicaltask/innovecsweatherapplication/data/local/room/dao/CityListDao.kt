package com.technicaltask.innovecsweatherapplication.data.local.room.dao

import androidx.room.*
import com.technicaltask.innovecsweatherapplication.data.local.room.dao.RoomCityData.Companion.TABLE_NAME

@Dao
interface CityListDao {

    @Query("SELECT * FROM  $TABLE_NAME  WHERE `key` = :key")
    suspend fun getCityByKey(key: String): RoomCityData?

    @Query("DELETE FROM $TABLE_NAME")
    suspend fun deleteAll()

    @Insert(entity = RoomCityData::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(city: RoomCityData)

}