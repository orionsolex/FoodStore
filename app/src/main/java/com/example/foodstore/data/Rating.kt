package com.example.foodstore.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Rating(


    @SerializedName("score")
    @Expose
    var score: Double? = null,
    @SerializedName("reviews")
    @Expose
    val reviews: Int? = null
)
