package com.example.myapplication.data.repository

import com.example.myapplication.data.model.DishesLocalModel
import com.example.myapplication.server.model.DataModel
import com.example.myapplication.server.service.DishesService

class DishesRepository(private val retrofit: DishesService = DishesService.create()) {

    suspend fun getDishesData() : List<DishesLocalModel>{
        return parseDishesData(retrofit.fetchDishesData())
    }

    fun parseDishesData(data : List<DataModel>) : List<DishesLocalModel>{

        val arrayList = arrayListOf<DishesLocalModel>()

        data.forEach {

            val dish = DishesLocalModel(
                name = it.name,
                image = it.image
            )
            arrayList.add(dish)
        }

        return arrayList
    }
}