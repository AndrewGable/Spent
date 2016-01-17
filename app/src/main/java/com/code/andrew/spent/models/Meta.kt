package com.code.andrew.spent.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Meta {

    @SerializedName("limit")
    @Expose
    val limit: Int? = null

    @SerializedName("name")
    @Expose
    val name: String? = null

    @SerializedName("number")
    @Expose
    val number: String? = null
}
