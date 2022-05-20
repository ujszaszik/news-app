package com.planday.compose.web

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.*
import androidx.compose.ui.viewinterop.AndroidView
import com.planday.compose.layout.LoadingBox
import com.planday.compose.layout.ProgressType

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebScreen(url: String) {

    var isLoading by remember { mutableStateOf(false) }

    LoadingBox(isLoading = isLoading, type = ProgressType.ABOVE_SCREEN) {

        AndroidView(factory = { context ->

            WebView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )

                webViewClient = object : WebViewClient() {
                    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                        super.onPageStarted(view, url, favicon)
                        isLoading = true
                    }

                    override fun onPageFinished(view: WebView?, url: String?) {
                        super.onPageFinished(view, url)
                        isLoading = false
                    }

                    override fun shouldOverrideUrlLoading(
                        view: WebView?,
                        request: WebResourceRequest?
                    ): Boolean {
                        return false
                    }
                }
                webChromeClient = WebChromeClient()

                settings.javaScriptEnabled = true
                settings.javaScriptCanOpenWindowsAutomatically = false

                clearCache(true)
                clearHistory()

                loadUrl(url)
            } //WebView
        }, update = { it.loadUrl(url) })
    } // LoadingBox
}