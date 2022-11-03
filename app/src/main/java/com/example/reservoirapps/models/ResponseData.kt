package com.example.reservoirapps.models

data class ResponseData(
    var CatchmentAreaRainfall: String,
    var CrossFlow: String,
    var DeadStorageLevel: String,
    var EffectiveCapacity: String,
    var FullWaterLevel: String,
    var InflowVolume: String,
    var Outflow: String,
    var OutflowDischarge: String,
    var OutflowTotal: String,
    var RecordTime: String,
    var RegulatoryDischarge: String,
    var ReservoirIdentifier: String,
    var ReservoirName: String
)