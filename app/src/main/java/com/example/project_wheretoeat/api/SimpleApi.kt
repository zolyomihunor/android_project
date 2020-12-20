package com.example.project_wheretoeat.api

import com.example.project_wheretoeat.model.Resdata
import com.example.project_wheretoeat.model.Restaurant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface SimpleApi {

    //Restaurant lista
    @GET("restaurants")
    suspend fun getRestaurants(
        @Query("name") name:String? = null,
        @Query("country") country:String? = "US"
    ): Resdata

    //Egy restaurant id alapjan
    @GET("restaurants/{id}")
    suspend fun getRestaurant(@Path("id") id: Int): Restaurant


}