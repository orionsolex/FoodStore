package com.example.foodstore.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("value")
    @Expose
    var value: Int?=null,

@SerializedName("currency")
@Expose
var currency:String? =null
)
