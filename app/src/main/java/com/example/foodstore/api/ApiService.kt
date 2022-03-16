package com.example.foodstore.api


import com.example.foodstore.data.JsonData
import com.example.foodstore.data.data
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("refined-metal-cheese")
    fun getData(): Single<data>

    @GET("refined-metal-cheese")
    fun getJsonData(): Single<JsonData>
}