package com.code.andrew.spent

import android.app.Activity
import android.os.Bundle
import android.view.Gravity.CENTER

import org.jetbrains.anko.*

class TransactionList : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TransactionListUi().setContentView(this)
    }
}

class TransactionListUi : AnkoComponent<TransactionList> {

    override fun createView(ui: AnkoContext<TransactionList>) = with(ui) {
        linearLayout {
            textView("Andrew!") {
                gravity = CENTER
            }
        }
    }
}