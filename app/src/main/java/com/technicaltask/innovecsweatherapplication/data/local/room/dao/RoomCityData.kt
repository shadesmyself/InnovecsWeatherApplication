package com.technicaltask.innovecsweatherapplication.data.local.room.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.technicaltask.innovecsweatherapplication.data.local.room.dao.RoomCityData.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class RoomCityData(

    @PrimaryKey @ColumnInfo(name = "key")
    val key: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "temp")
    val temp: Double,

    @ColumnInfo(name = "temp_max")
    val temp_max: Double,

    @ColumnInfo(name = "temp_min")
    val temp_min: Double,

    @ColumnInfo(name = "wind_speed")
    val wind_speed: Double,

    @ColumnInfo(name = "feels_like")
    val feels_like: Double,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "icon")
    val icon: String
) {
    companion object {
        const val TABLE_NAME = "city_list_entities_table"
    }

}

