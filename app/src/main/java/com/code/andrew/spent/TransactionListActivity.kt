package com.code.andrew.spent

import android.app.ListActivity
import android.app.ProgressDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import com.code.andrew.spent.models.PlaidAccount
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Either
import com.google.gson.GsonBuilder

import org.jetbrains.anko.*

import com.github.salomonbrys.kotson.fromJson

class TransactionListActivity : ListActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create the list using anko
        TransactionListActivityUi().setContentView(this)

        // Show loading modal
        val dialog = ProgressDialog.show(this, "", "Loading. Please wait...", true)

        // Set up the list with an empty array adapter
        val mAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListOf(""))
        listAdapter = mAdapter

        val url = "https://tartan.plaid.com/connect?"
        val body = "client_id=test_id&secret=test_secret&username=plaid_test&" +
                    "password=plaid_good&type=wells"

        Fuel.post(url + body).responseString { request, response, either ->
            when (either) {
                is Either.Left -> {
                    error("Network error - response: " + response)
                    toast("Network error, please try again.")
                }
                is Either.Right -> {
                    val gson = GsonBuilder().create()
                    val plaidAccount = gson.fromJson<PlaidAccount>(either.right)

                    mAdapter.clear()

                    for (toDo in plaidAccount.transactions) {
                        mAdapter.add(toDo.name)
                    }

                    mAdapter.notifyDataSetChanged()
                    dialog.hide()
                }
            }
        }
    }
}

class TransactionListActivityUi() : AnkoComponent<TransactionListActivity>, AnkoLogger {

    override fun createView(ui: AnkoContext<TransactionListActivity>) = with(ui) {
        linearLayout {
            listView {
                id = android.R.id.list
            }
        }
    }
}