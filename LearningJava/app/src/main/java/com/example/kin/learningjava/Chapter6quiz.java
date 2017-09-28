package com.example.kin.learningjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Chapter6quiz extends AppCompatActivity {
    String name;
    int scoretestsix;
    String testsix;
    String type = "submittestsix";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter6quiz);
        Bundle bundle=getIntent().getExtras();
        name=bundle.getString("username");
        //Quiz implementation



        testsix=Integer.toString(scoretestsix);
        BackgroundWorker background = new BackgroundWorker(Chapter6quiz.this);
        background.execute(type,name,testsix);
    }
}
