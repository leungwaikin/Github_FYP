package com.example.kin.learningjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Lenovo on 13/5/2018.
 */

public class Exercise extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.online_or_offline);

        final Button output = (Button) findViewById(R.id.online);
        final Button error = (Button) findViewById(R.id.offline);
        output.setOnClickListener(new View.OnClickListener(){

            public void onClick(View w) {
                Intent jumpage=new Intent(Exercise.this,Exercise2.class);
                Bundle bundle = new Bundle();
               // bundle.putString("username",name);
                jumpage.putExtras(bundle);
                startActivity(jumpage);
            }
        });


        error.setOnClickListener(new View.OnClickListener(){

            public void onClick(View w) {
                Intent jumpage=new Intent(Exercise.this,CompilerActivity.class);
                Bundle bundle = new Bundle();
              //  bundle.putString("username",name);
                jumpage.putExtras(bundle);
                startActivity(jumpage);
            }
        });
    }

}
