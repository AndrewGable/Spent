package com.code.andrew.spent.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BankAccount {

    @SerializedName("_id")
    @Expose
    val id: String? = null

    @SerializedName("_item")
    @Expose
    val item: String? = null

    @SerializedName("_user")
    @Expose
    val user: String? = null

    @SerializedName("balance")
    @Expose
    val balance: Balance? = null

    @SerializedName("institution_type")
    @Expose
    val institutionType: String? = null

    @SerializedName("meta")
    @Expose
    val meta: Meta? = null

    @SerializedName("subtype")
    @Expose
    val subtype: String? = null

    @SerializedName("type")
    @Expose
    val type: String? = null
}
