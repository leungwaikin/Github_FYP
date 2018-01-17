package com.example.kin.learningjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Exercise extends AppCompatActivity {
    WebView mwebview;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        Bundle bundle=getIntent().getExtras();
        name=bundle.getString("username");
        mwebview = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = mwebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mwebview.loadUrl("https://www.compilejava.net");
    }
}
