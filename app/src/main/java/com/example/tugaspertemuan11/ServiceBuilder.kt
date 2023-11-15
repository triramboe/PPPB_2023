package com.example.tugaspertemuan11

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceBuilder {


    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api-sekolah-indonesia.vercel.app")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun<T>buildService(service: Class<T>):T{
        return retrofit.create(service)
    }
}