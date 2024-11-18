package com.example.myapplication.server.model

import com.google.gson.annotations.SerializedName

data class DataModel(

    @SerializedName("dishId")
    val id: String,

    @SerializedName("dishName")
    val name: String,

    @SerializedName("imageUrl")
    val image: String,

    @SerializedName("isPublished")
    val isPublished: Boolean
)
