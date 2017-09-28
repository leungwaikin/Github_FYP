package com.example.kin.learningjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Chapter4quiz extends AppCompatActivity {
    String name;
    int scoretestfour;
    String testfour;
    String type = "submittestfour";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter4quiz);
        Bundle bundle=getIntent().getExtras();
        name=bundle.getString("username");
         //Quiz implementation

        testfour=Integer.toString(scoretestfour);
        BackgroundWorker background = new BackgroundWorker(Chapter4quiz.this);
        background.execute(type,name,testfour);
    }
}
