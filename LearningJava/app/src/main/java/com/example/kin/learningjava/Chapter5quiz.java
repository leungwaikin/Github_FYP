package com.example.kin.learningjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Chapter5quiz extends AppCompatActivity {
    String name;
    int scoretestfive;
    String testfive;
    String type = "submittestfive";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter5quiz);
        Bundle bundle=getIntent().getExtras();
        name=bundle.getString("username");
        //Quiz implementation


        testfive=Integer.toString(scoretestfive);
        BackgroundWorker background = new BackgroundWorker(Chapter5quiz.this);
        background.execute(type,name,testfive);
    }
}
