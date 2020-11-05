package com.example.ancor_task_1.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LatheApi(
    @Json(name = "model") var model: String,
    @Json(name = "producer") val producer: String,
    @Json(name = "machineLocation") val machineLacation: String,
    @Json(name = "diameter") val diameter: String,
    @Json(name = "lengthMax") val lengthMax: String,
    @Json(name = "condition1") val condition: String,
    @Json(name = "video1") val imageUrl: String
)