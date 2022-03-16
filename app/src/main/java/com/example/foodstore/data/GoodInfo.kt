package com.example.foodstore.data

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class GoodInfo (
    @SerializedName("_id")
    @Expose
    val id: String? = null,

    @SerializedName("slug")
    @Expose
    val slug: String? = null,

    @SerializedName("images")
    @Expose
    var images: List<String>? = null,

    @SerializedName("vendorCode")
    @Expose
    val vendorCode: Int? = null,

    @SerializedName("status")
    @Expose
    val status: Int? = null,

    @SerializedName("hit")
    @Expose
    val hit: Boolean? = null,

    @SerializedName("new")
    @Expose
    val new: Boolean? = null,

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("subTitle")
    @Expose
    var subTitle: String? = null,

    @SerializedName("description")
    @Expose
    var description: String? = null,

    @SerializedName("price")
    @Expose
    val price: Price? = null,

    @SerializedName("tags")
    @Expose
    val tags: List<String>? = null,

    @SerializedName("count")
    @Expose
    val count: Int? = null,


    @SerializedName("shop")
    @Expose
    val shop: Shop? = null,

    @SerializedName("offers")
    @Expose
    val offers: List<Any>? = null,

    @SerializedName("score")
    @Expose
    val score: Int? = null,

    @SerializedName("rating")
    @Expose
    val rating: Rating? = null,

    @SerializedName("characteristics")
    @Expose
    val characteristics: List<List<String>>? = null,

)