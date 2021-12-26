package com.technicaltask.innovecsweatherapplication.di.module

import com.google.gson.GsonBuilder
import com.technicaltask.innovecsweatherapplication.MyApp
import com.technicaltask.innovecsweatherapplication.data.remote.OpenWeatherApi
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RetrofitModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(Interceptor { chain -> var request = chain.request()
                val url = request.url.newBuilder().build()
                request = request.newBuilder().url(url).build()
                chain.proceed(request)
            })
            .addInterceptor(interceptor)
            .build()

            val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .client(client)
            .baseUrl(MyApp.OPEN_WEATHER_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun provideMainApi(retrofit: Retrofit): OpenWeatherApi = retrofit.create(OpenWeatherApi::class.java)

}