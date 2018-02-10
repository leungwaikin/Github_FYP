package com.example.kin.learningjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Quiz5result extends AppCompatActivity {
    String testscore,name;
    TextView textView0,textView1;
    ImageButton imgbutton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz5result);
        Bundle bundle=getIntent().getExtras();
        testscore=bundle.getString("score");
        name=bundle.getString("username");
        textView0=(TextView)findViewById(R.id.textView0);
        textView1=(TextView)findViewById(R.id.textView1);
        textView1.setText("Your score in this quiz is "+ testscore );
        imgbutton1=(ImageButton)findViewById(R.id.imageButton1);
        imgbutton1.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent jumpage=new Intent(Quiz5result.this,Chapter5.class);
                Bundle bundle = new Bundle();
                bundle.putString("username",name);
                jumpage.putExtras(bundle);
                startActivity(jumpage);
            }
        });
    }
}
