package com.example.reservoirapps.models

data class ReservoirInfo(
    var page: Int,
    var responseData: List<ResponseData>,
    var size: Int,
    var totalDataSize: Int,
    var totalPage: Int
)