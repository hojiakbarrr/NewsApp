package com.example.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.newsapp.R

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val euro = intent.extras?.get("url")

        val dataurl = euro
        Log.d("dataurl","OnResponse Success ${dataurl}")



        val mWebView = findViewById<View>(R.id.webviewActivity) as WebView

        mWebView.loadUrl(dataurl.toString())

        val webSetting = mWebView.settings
        webSetting.javaScriptEnabled = true

        mWebView.webViewClient = WebViewClient()

        mWebView.canGoBack()
        mWebView.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK

                && event.action == MotionEvent.ACTION_UP
                && mWebView.canGoBack()){
                mWebView.goBack()
                return@OnKeyListener true
            }

            false

        })


    }
}