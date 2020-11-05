package com.example.ancor_task_1.model

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitCreate {

    private const val LATHE_URL = "http://q11.jvmhost.net/"

    fun getLatheApi(): LatheInterface {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addNetworkInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(LATHE_URL)
            .build()

        return retrofit.create(LatheInterface::class.java)
    }
}