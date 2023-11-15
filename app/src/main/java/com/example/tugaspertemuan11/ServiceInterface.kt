package com.example.tugaspertemuan11

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ServiceInterface {

    @Headers("Content-Type:application/json")
    @GET("/sekolah?page=100&perPage=50")
    fun getAllProducts():Call<ApiResponse>
}