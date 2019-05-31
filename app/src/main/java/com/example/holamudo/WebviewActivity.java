package com.example.holamudo;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebviewActivity extends AppCompatActivity {
    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        myWebView =findViewById(R.id.wvWeb);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("https://stackoverflow.com/questions/7623802/webview-webpage-not-available");
    }
}
