package com.code.andrew.spent

import android.app.ListActivity
import android.app.ProgressDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import com.code.andrew.spent.models.ToDo
import com.github.kittinunf.fuel.core.Either
import com.github.kittinunf.fuel.httpGet
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

        // Call URL to get test items
        val url = "http://jsonplaceholder.typicode.com/todos/"
        url.httpGet().responseString { request, response, either ->
            when (either) {
                is Either.Left -> toast("Network error, please try again.")
                is Either.Right -> {
                    var gson = GsonBuilder().create()
                    var toDos = gson.fromJson<List<ToDo>>(either.right)

                    mAdapter.clear()

                    for (toDo in toDos) {
                        mAdapter.add(toDo.title)
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