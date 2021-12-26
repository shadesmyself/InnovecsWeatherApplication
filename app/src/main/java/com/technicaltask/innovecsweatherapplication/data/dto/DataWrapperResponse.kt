package com.technicaltask.innovecsweatherapplication.data.dto

import com.google.gson.annotations.SerializedName

    data class DataWrapperResponse(

        @SerializedName("cod")
        val cod: Int?,

        @SerializedName("message")
        val message: String?
    )
