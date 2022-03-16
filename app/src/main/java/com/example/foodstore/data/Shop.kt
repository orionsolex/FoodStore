package com.example.foodstore.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Shop(
    @SerializedName("slug")
    @Expose
    val slug: String? = null,
    @SerializedName("title")
    @Expose
    var title: String? = null,
    @SerializedName("image")
    @Expose
    var image: String? = null,
    @SerializedName("subTitle")
    @Expose
    var subTitle: String? = null,
    @SerializedName("info")
    @Expose
    val info: String? = null
)
