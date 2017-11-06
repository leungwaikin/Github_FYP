package com.example.kin.learningjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Chapter1quiz extends AppCompatActivity {
    String name;
    int scoretestone = 20;
    String testone;
    String type = "submittestone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1quiz);
        Bundle bundle=getIntent().getExtras();
        name=bundle.getString("username");
        //Quiz implementation



        //to do database
        testone=Integer.toString(scoretestone);
        BackgroundWorker background = new BackgroundWorker(Chapter1quiz.this);
        background.execute(type,name,testone);

    }
}
