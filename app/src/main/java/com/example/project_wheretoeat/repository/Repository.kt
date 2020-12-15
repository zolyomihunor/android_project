package com.example.project_wheretoeat.repository

import com.example.project_wheretoeat.api.RetrofitInstance
import com.example.project_wheretoeat.model.Resdata
import com.example.project_wheretoeat.model.Restaurant
import retrofit2.Response

class Repository {

    suspend fun getRestaurants(): Resdata{
        return RetrofitInstance.api.getRestaurants()
    }

    suspend fun getOneRestaurant(id:Int): Restaurant {
        return RetrofitInstance.api.getRestaurant(id)
    }


}