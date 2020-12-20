package com.example.project_wheretoeat.api

import com.example.project_wheretoeat.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//regi szerverhez
/*object RetrofitInstance {

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val api: SimpleApi by lazy{
        retrofit.create(SimpleApi::class.java)
    }
}*/


//uj szerverhez
object RetrofitInstance {
    private val retrofit by lazy {

        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                //.client(okHttp)
                .build()
    }

    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}