package com.example.admin.demo.thridwidget.slidinglayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.example.admin.demo.R;

/**
 * Created by Linhh on 16/4/15.
 */
public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        WebView webView = (WebView) this.findViewById(R.id.webView);
         webView.loadUrl("http://www.baidu.com");
    }
}