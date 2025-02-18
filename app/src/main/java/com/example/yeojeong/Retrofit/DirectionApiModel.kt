package com.example.yeojeong.Retrofit

import com.google.gson.annotations.SerializedName

data class DirectionApiModel(
    var routes: List<DirectionApiModelRoutes>
)

data class Bounds(
    var northeast: LatLngLiteral,
    var southwest: LatLngLiteral
)

data class DirectionApiModelRoutes(
    var bounds: Bounds,
    var legs: List<Legs>
)

data class Legs(
    @SerializedName("end_location")
    var endLocation: EndLocation,
    @SerializedName("start_location")
    var startLocation: StartLocation,
    var steps: List<DirectionsStep>
)

data class DirectionsStep(
    @SerializedName("end_location")
    var endLocation: EndLocation,
    @SerializedName("start_location")
    var startLocation: StartLocation,
    @SerializedName("polyline")
    var polyline: DirectionsPolyline
)

data class DirectionsPolyline(
    var points: String
)

data class LatLngLiteral(
    var lat: Double,
    var lng: Double
)

data class EndLocation(
    var lat: Double,
    var lng: Double
)

data class StartLocation(
    var lat: Double,
    var lng: Double
)