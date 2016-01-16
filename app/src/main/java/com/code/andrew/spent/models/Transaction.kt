package com.code.andrew.spent.models

import java.util.ArrayList
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Transaction pojo, holds the plaid transaction
 */
class Transaction {

    @SerializedName("_account")
    @Expose
    val account: String? = null

    @SerializedName("_id")
    @Expose
    val id: String? = null

    @SerializedName("amount")
    @Expose
    val amount: Double? = null

    @SerializedName("date")
    @Expose
    val date: String? = null

    @SerializedName("meta")
    @Expose
    val meta: Meta_? = null

    @SerializedName("pending")
    @Expose
    val pending: Boolean? = null

    @SerializedName("type")
    @Expose
    val type: Type? = null

    @SerializedName("category")
    @Expose
    val category: List<String> = ArrayList()

    @SerializedName("category_id")
    @Expose
    val categoryId: String? = null

    @SerializedName("score")
    @Expose
    val score: Score? = null

    @SerializedName("name")
    @Expose
    val name: String? = null
}
