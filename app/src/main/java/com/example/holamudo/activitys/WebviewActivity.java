package com.example.holamudo.activitys;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import com.example.holamudo.R;

public class WebviewActivity extends AppCompatActivity {
    EditText etUri;
    Button btnIr;
    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        etUri = findViewById(R.id.etUrl);
        btnIr = findViewById(R.id.btnIrWeb);
        myWebView =findViewById(R.id.wvWeb);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());



        btnIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myWebView.loadUrl(etUri.getText().toString());
            }
        });



    }
}
