package com.example.reservoirapps.di

import com.example.reservoirapps.api.ApiService
import com.example.reservoirapps.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn
object ReservoirModule {
    @Provides
    @Singleton
    fun provideRetrofitInstance():ApiService =
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

}