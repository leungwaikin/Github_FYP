package com.example.kin.learningjava;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainPage extends AppCompatActivity {
    Button logout;
    TextView textView1;
    ImageButton imgbutton1,imgbutton2,imgbutton3,imgbutton4;
    String name, temp;
    Button helpbutton;
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Bundle bundle=getIntent().getExtras();
        name=bundle.getString("username");
        textView1=(TextView)findViewById(R.id.textView2);
        temp = "Welcome, "+ name;
        textView1.setText(temp);
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

        helpbutton=(Button)findViewById(R.id.help);
        helpbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent jumpage=new Intent(MainPage.this,help.class);
                Bundle bundle = new Bundle();
                bundle.putString("username",name);
                jumpage.putExtras(bundle);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setView(R.layout.online_or_offline);
                final AlertDialog dialog = builder.create();

                dialog.show();

                final Button output = (Button) dialog.findViewById(R.id.online);
                final Button error = (Button) dialog.findViewById(R.id.offline);
                output.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View w) {
                        Intent jumpage=new Intent(MainPage.this,Exercise2.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("username",name);
                        jumpage.putExtras(bundle);
                        startActivity(jumpage);
                    }
                });


                error.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View w) {
                        Intent jumpage=new Intent(MainPage.this,CompilerActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("username",name);
                        jumpage.putExtras(bundle);
                        startActivity(jumpage);
                    }
                });
               /* Intent jumpage=new Intent(MainPage.this,Exercise.class);
                Bundle bundle = new Bundle();
                bundle.putString("username",name);
                jumpage.putExtras(bundle);
                startActivity(jumpage);*/
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
