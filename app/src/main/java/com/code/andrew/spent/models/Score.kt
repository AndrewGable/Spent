package com.code.andrew.spent.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Score {

    @SerializedName("location")
    @Expose
    val location: Location_? = null

    @SerializedName("name")
    @Expose
    val name: Int? = null
}
