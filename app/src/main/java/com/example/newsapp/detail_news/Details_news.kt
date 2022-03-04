package com.example.newsapp.detail_news

import android.os.Bundle
import android.view.*
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.R
import com.example.newsapp.static.Ssylka


class Details_news : Fragment() {

    companion object {
        fun newInstance() = Details_news()
    }

    private lateinit var viewModel: DetailsNewsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val ww =  inflater.inflate(R.layout.details_news_fragment, container, false)

        val url = Ssylka.allUsers

        val mWebView = ww.findViewById<View>(R.id.webview) as WebView

        mWebView.loadUrl(url)

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



    return ww
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailsNewsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}