package com.example.nitish.myapplication.activity



import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.view.MenuItem
import android.widget.Toast
import com.example.nitish.myapplication.R
import com.example.nitish.myapplication.utils.Constants


class ActivityWebview :  AppCompatActivity() {



    var wvContent: WebView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_page)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setTitle(R.string.title_activity_detail)
        if (!Constants.isInternetAvailable(this)) {
            Toast.makeText(this, "Internet is not working", Toast.LENGTH_SHORT).show()
            return
        }
        initialise()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
    private fun initialise() {
        wvContent = findViewById(R.id.wv_content)
        wvContent?.webViewClient = MyWebViewClient()
        var webSettings = wvContent!!.getSettings()
        webSettings.setJavaScriptEnabled(true)
        wvContent!!.loadUrl(intent.getStringExtra("url"))
    }

    private inner class MyWebViewClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            return super.shouldOverrideUrlLoading(view, request)
        }
    }

    override fun onBackPressed() {
        if (this.wvContent!!.canGoBack()) {
            this.wvContent!!.goBack()
        } else {
            return super.onBackPressed()
        }

    }

    override fun onResume() {
        super.onResume()


    }


}