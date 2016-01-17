package com.code.andrew.spent.models

import java.util.ArrayList
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PlaidAccount {

    @SerializedName("accounts")
    @Expose
    val bankAccounts: List<BankAccount> = ArrayList()

    @SerializedName("transactions")
    @Expose
    val transactions: List<Transaction> = ArrayList()

    @SerializedName("access_token")
    @Expose
    val accessToken: String? = null
}
