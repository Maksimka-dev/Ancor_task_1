package com.example.ancor_task_1.model

import retrofit2.Response
import retrofit2.http.GET

interface LatheInterface {

    @GET("lathe_json")
    suspend fun getLathe(): Response<List<LatheApi>>
}