package com.example.kin.learningjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Chapter2quiz extends AppCompatActivity {
    String name;
    int scoretesttwo=8;
    String testtwo;
    String type = "submittesttwo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2quiz);

        Bundle bundle=getIntent().getExtras();
        name=bundle.getString("username");
        //Quiz implementation



        //to do database
        testtwo=Integer.toString(scoretesttwo);
        BackgroundWorker background = new BackgroundWorker(Chapter2quiz.this);
        background.execute(type,name,testtwo);
    }
}
