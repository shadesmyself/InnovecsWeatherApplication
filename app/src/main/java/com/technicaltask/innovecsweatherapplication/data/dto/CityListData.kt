package com.technicaltask.innovecsweatherapplication.data.dto

import com.google.gson.annotations.SerializedName

data class CityListData (
    @SerializedName( "name")
    val name: String,

    @SerializedName( "temp")
    val temp: Double,

    @SerializedName( "temp_max")
    val temp_max: Double,

    @SerializedName("temp_min")
    val temp_min: Double,

    @SerializedName( "wind_speed")
    val wind_speed: Double,

    @SerializedName("feels_like")
    val feels_like: Double,

    @SerializedName("description")
    val description: String,

    @SerializedName( "icon")
    val icon: String
    )
{

}