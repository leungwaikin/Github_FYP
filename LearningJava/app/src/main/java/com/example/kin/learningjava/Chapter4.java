package com.example.kin.learningjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Chapter4 extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter4);
        btn1=(Button)findViewById((R.id.button1));
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent jumpage=new Intent(Chapter4.this,Chapter4a.class);
                startActivity(jumpage);
            }
        });
        btn2=(Button)findViewById((R.id.button2));
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent jumpage=new Intent(Chapter4.this,Chapter4b.class);
                startActivity(jumpage);
            }
        });
        btn3=(Button)findViewById((R.id.button3));
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent jumpage=new Intent(Chapter4.this,Chapter4c.class);
                startActivity(jumpage);
            }
        });
        btn4=(Button)findViewById((R.id.button4));
        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent jumpage=new Intent(Chapter4.this,Chapter4d.class);
                startActivity(jumpage);
            }
        });
        btn5=(Button)findViewById((R.id.button5));
        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent jumpage=new Intent(Chapter4.this,Chapter4e.class);
                startActivity(jumpage);
            }
        });
        btn6=(Button)findViewById((R.id.button6));
        btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent jumpage=new Intent(Chapter4.this,Chapter4f.class);
                startActivity(jumpage);
            }
        });
        btn7=(Button)findViewById((R.id.button7));
        btn7.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent jumpage=new Intent(Chapter4.this,Chapter4g.class);
                startActivity(jumpage);
            }
        });
        btn8=(Button)findViewById((R.id.button8));
        btn8.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent jumpage=new Intent(Chapter4.this,Chapter4h.class);
                startActivity(jumpage);
            }
        });
        btn9=(Button)findViewById((R.id.button9));
        btn9.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent jumpage=new Intent(Chapter4.this,Chapter4i.class);
                startActivity(jumpage);
            }
        });
        btn10=(Button)findViewById((R.id.button10));
        btn10.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent jumpage=new Intent(Chapter4.this,Chapter4j.class);
                startActivity(jumpage);
            }
        });
        btn11=(Button)findViewById((R.id.button11));
        btn11.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent jumpage=new Intent(Chapter4.this,Chapter4k.class);
                startActivity(jumpage);
            }
        });
        btn12=(Button)findViewById((R.id.button12));
        btn12.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent jumpage=new Intent(Chapter4.this,Chapter4l.class);
                startActivity(jumpage);
            }
        });
        btn13=(Button)findViewById((R.id.button13));
        btn13.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent jumpage=new Intent(Chapter4.this,Chapter4m.class);
                startActivity(jumpage);
            }
        });
        btn14=(Button)findViewById((R.id.button14));
        btn14.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent jumpage=new Intent(Chapter4.this,Chapter4quiz.class);
                startActivity(jumpage);
            }
        });

    }
}