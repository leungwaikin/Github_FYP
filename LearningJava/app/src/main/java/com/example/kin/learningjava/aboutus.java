package com.example.kin.learningjava;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class aboutus extends AppCompatActivity {
    TextView text1,text2,text3,text4,text5,text6,text7,text8,text9,text10;
    ImageView icon1,icon2,icon3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        icon1=(ImageView)findViewById(R.id.imageView1);
        icon2=(ImageView)findViewById(R.id.imageView2);
        icon3=(ImageView)findViewById(R.id.imageView3);
        text1=(TextView)findViewById(R.id.textView1);
        text2=(TextView)findViewById(R.id.textView2);
        text3=(TextView)findViewById(R.id.textView3);
        text4=(TextView)findViewById(R.id.textView4);
        text5=(TextView)findViewById(R.id.textView5);
        text6=(TextView)findViewById(R.id.textView6);
        text7=(TextView)findViewById(R.id.textView7);
        text8=(TextView)findViewById(R.id.textView8);
        text9=(TextView)findViewById(R.id.textView9);
        text10=(TextView)findViewById(R.id.textView10);
    }

}
