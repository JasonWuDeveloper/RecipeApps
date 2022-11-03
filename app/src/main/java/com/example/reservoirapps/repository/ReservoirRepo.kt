package com.example.reservoirapps.repository

import com.example.reservoirapps.api.ApiService
import javax.inject.Inject

class ReservoirRepo
@Inject constructor(private val apiService: ApiService) {
    suspend fun getReservoir() = apiService.getReservoirInfo()
}