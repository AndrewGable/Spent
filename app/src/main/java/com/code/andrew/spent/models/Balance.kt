package com.code.andrew.spent.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Balance {

    @SerializedName("available")
    @Expose
    val available: Double? = null

    @SerializedName("current")
    @Expose
    val current: Double? = null
}
