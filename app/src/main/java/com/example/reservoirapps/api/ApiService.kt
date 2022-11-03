package com.example.reservoirapps.api

import com.example.reservoirapps.models.ReservoirInfo
import com.example.reservoirapps.util.Constants.END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(END_POINT)
    suspend fun getReservoirInfo():Response<ReservoirInfo>
}