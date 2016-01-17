package com.code.andrew.spent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.Window
import android.webkit.*
import java.io.File

/**
 * Opens Plaid Link in a browser window to authenticate a new user
 * @see https://github.com/plaid/link
 */
class PlaidLinkActivity : Activity() {

    private var mWebView: WebView? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        mWebView = WebView(this)
        val settings = mWebView!!.settings
        settings.domStorageEnabled = true
        settings.javaScriptEnabled = true
        mWebView!!.setWebChromeClient(WebChromeClient())
        mWebView!!.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }
        })

        mWebView!!.loadUrl("file:///android_asset/plaid.html")
        this.setContentView(mWebView)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView!!.canGoBack()) {
            mWebView!!.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}
