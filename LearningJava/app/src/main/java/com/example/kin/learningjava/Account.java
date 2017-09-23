package com.example.kin.learningjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Account extends AppCompatActivity {
    TextView textView0,textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10,textView11,textView12,textView13,textView14,textView15,textView16,textView17,textView18,textView19,textView20;
    EditText newpassword,reenterpassword;
    Button submit;
    String password;
    String secondpw;
    String name;
    String type="changepw";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Bundle bundle=getIntent().getExtras();
        name=bundle.getString("username");
        textView0=(TextView)findViewById(R.id.textView0);
        textView1=(TextView)findViewById(R.id.textView1);
        textView2=(TextView)findViewById(R.id.textView2);
        textView3=(TextView)findViewById(R.id.textView3);
        textView4=(TextView)findViewById(R.id.textView4);
        textView5=(TextView)findViewById(R.id.textView5);
        textView6=(TextView)findViewById(R.id.textView6);
        textView7=(TextView)findViewById(R.id.textView7);
        textView8=(TextView)findViewById(R.id.textView8);
        textView9=(TextView)findViewById(R.id.textView9);
        textView10=(TextView)findViewById(R.id.textView10);
        textView11=(TextView)findViewById(R.id.textView11);
        textView12=(TextView)findViewById(R.id.textView12);
        textView13=(TextView)findViewById(R.id.textView13);
        textView14=(TextView)findViewById(R.id.textView14);
        textView15=(TextView)findViewById(R.id.textView15);
        textView16=(TextView)findViewById(R.id.textView16);
        textView17=(TextView)findViewById(R.id.textView17);
        textView18=(TextView)findViewById(R.id.textView18);
        textView19=(TextView)findViewById(R.id.textView19);
        textView20=(TextView)findViewById(R.id.textView20);
        newpassword=(EditText)findViewById(R.id.editText1);
        reenterpassword=(EditText)findViewById(R.id.editText2);
        submit=(Button)findViewById(R.id.button1);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                password= newpassword.getText().toString();
                secondpw=reenterpassword.getText().toString();
                if(password.equals("")) {
                    Toast.makeText(Account.this,"You didn't enter your new password", Toast.LENGTH_SHORT).show();
                }else if(secondpw.equals("")){
                    Toast.makeText(Account.this,"You didn't re-enter your new password", Toast.LENGTH_SHORT).show();
                }else if(!(password.equals(secondpw))){
                    Toast.makeText(Account.this,"Mismatch password", Toast.LENGTH_SHORT).show();
                }else{
                    //to-do-database
                    BackgroundWorker background = new BackgroundWorker(Account.this);
                    background.execute(type,name,password);
                }

            }
        });

    }
}
