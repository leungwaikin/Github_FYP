package com.example.kin.learningjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainPage extends AppCompatActivity {
    Button logout;
    ImageButton imgbutton1,imgbutton2,imgbutton3,imgbutton4;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Bundle bundle=getIntent().getExtras();
        name=bundle.getString("username");

        logout=(Button)findViewById(R.id.button1);
        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {

                Toast.makeText(MainPage.this,"You log out successfully", Toast.LENGTH_SHORT).show();
                Intent jumpage=new Intent(MainPage.this,MainActivity.class);
                jumpage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //Closing all activities
                jumpage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                jumpage.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  //Add new Flag to strat new activity
                startActivity(jumpage);
            }
        });
        imgbutton1=(ImageButton)findViewById(R.id.imageButton1);
        imgbutton1.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent jumpage=new Intent(MainPage.this,Chapterlist.class);
                Bundle bundle = new Bundle();
                bundle.putString("username",name);
                jumpage.putExtras(bundle);
                startActivity(jumpage);
            }
        });
        imgbutton2=(ImageButton)findViewById(R.id.imageButton2);
        imgbutton2.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent jumpage=new Intent(MainPage.this,Exercise.class);
                Bundle bundle = new Bundle();
                bundle.putString("username",name);
                jumpage.putExtras(bundle);
                startActivity(jumpage);
            }
        });
        imgbutton3=(ImageButton)findViewById(R.id.imageButton3);
        imgbutton3.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent jumpage=new Intent(MainPage.this,aboutus.class);
                Bundle bundle = new Bundle();
                bundle.putString("username",name);
                jumpage.putExtras(bundle);
                startActivity(jumpage);
            }
        });
        imgbutton4=(ImageButton)findViewById(R.id.imageButton4);
        imgbutton4.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent jumpage=new Intent(MainPage.this,Account.class);
                Bundle bundle = new Bundle();
                bundle.putString("username",name);
                jumpage.putExtras(bundle);
                startActivity(jumpage);
            }
        });

    }

}
