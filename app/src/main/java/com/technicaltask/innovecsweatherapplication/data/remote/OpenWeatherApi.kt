package com.technicaltask.innovecsweatherapplication.data.remote

import com.technicaltask.innovecsweatherapplication.data.dto.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface OpenWeatherApi {
    @GET("data/2.5/weather/")
   suspend fun getWeather(@QueryMap queryMap: HashMap<String, String> ): Response<BaseResponse>

}