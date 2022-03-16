package com.example.foodstore.data

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class data (

    @SerializedName("data")
    @Expose
    var goodInfo: GoodInfo? = null
) {



}