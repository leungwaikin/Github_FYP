package com.example.kin.learningjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Chapter3quiz extends AppCompatActivity {
    String name;
    int scoretestthree;
    String testthree;
    String type = "submittestthree";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter3quiz);
        Bundle bundle=getIntent().getExtras();
        name=bundle.getString("username");
        //Quiz implementation



        //to do database
        testthree=Integer.toString(scoretestthree);
        BackgroundWorker background = new BackgroundWorker(Chapter3quiz.this);
        background.execute(type,name,testthree);
    }
}
