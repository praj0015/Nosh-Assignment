package com.example.myapplication.server.service

import com.example.myapplication.server.model.DataModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface DishesService {

    @GET("nosh-assignment")
    suspend fun fetchDishesData() : List<DataModel>

    companion object {

        const val BASE_URL = "https://fls8oe8xp7.execute-api.ap-south-1.amazonaws.com/dev/"

        fun create() : DishesService {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(DishesService::class.java)
        }
    }
}