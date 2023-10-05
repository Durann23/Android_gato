package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

public class inicio extends AppCompatActivity {
    WebView gifImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        gifImageView = findViewById(R.id.load);

        WebSettings webSettings = gifImageView.getSettings();

        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);

        gifImageView.loadUrl("file:///android_res/drawable/coye.gif");




        Intent i=new Intent(this, MainActivity.class);

        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {

                startActivity(i);
            }
        }.start();
    }
}