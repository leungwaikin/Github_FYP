package com.example.kin.learningjava;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class help extends AppCompatActivity {
    TextView text0;
    TextView text2;
    TextView text3;
    TextView text4;
    TextView text5;
    TextView text6;
    TextView text7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        text0=(TextView)findViewById(R.id.textView0);
        text2=(TextView)findViewById(R.id.textView2);
        text3=(TextView)findViewById(R.id.textView3);
        text4=(TextView)findViewById(R.id.textView4);
        text5=(TextView)findViewById(R.id.textView5);
        text6=(TextView)findViewById(R.id.textView6);
        text7=(TextView)findViewById(R.id.textView7);
        text2.setTextColor(Color.parseColor("#808080"));
        text3.setTextColor(Color.parseColor("#808080"));
        text4.setTextColor(Color.parseColor("#808080"));
        text5.setTextColor(Color.parseColor("#808080"));
        text6.setTextColor(Color.parseColor("#808080"));
        text7.setTextColor(Color.parseColor("#808080"));
    }
}
