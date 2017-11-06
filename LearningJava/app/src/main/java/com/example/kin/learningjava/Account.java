package com.example.kin.learningjava;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Account extends AppCompatActivity {
    TextView textView0,textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10,textView11,textView12,textView13,textView14;
    EditText newpassword,reenterpassword;
    Button submit,display;
    String password;
    String secondpw;
    String name;
    String type="display";
    String t1,t2,t3,t4,t5,t6;

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
        newpassword=(EditText)findViewById(R.id.editText1);
        reenterpassword=(EditText)findViewById(R.id.editText2);

        submit=(Button)findViewById(R.id.button1);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                password= newpassword.getText().toString();
                secondpw=reenterpassword.getText().toString();
                type="changepw";
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
        new localBackgroundWorker(Account.this).execute(type,name);


    }
    private class localBackgroundWorker extends AsyncTask<String,Void,String> {
        Context context;
        localBackgroundWorker (Context ctx) {
            context=ctx;
        }
        @Override
        protected String doInBackground(String... params) {
            String type = params[0];
            String displayrecord_url="https://leungwaikin.000webhostapp.com/displayrecord.php";

            if(type.equals("display")){
                try {
                    URL url = new URL(displayrecord_url);
                    String username = params[1];
                    System.out.print(username);
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                    String post_data= URLEncoder. encode("username","UTF-8")+"="+URLEncoder. encode(username,"UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream= httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                    String result="";
                    String line="";
                    while ((line=bufferedReader.readLine())!= null){
                        result+=line;
                    }
                    result=result.replace("connection success","");
                    result=result.replace("{","");
                    result=result.replace("[","");
                    result=result.replace("]","");
                    result=result.replace("}","");
                    result=result.replace("\"","");
                    System.out.println(result);
                    String[] parts = result.split(",");
                    System.out.println(parts[0]);
                    t1= parts[0].substring(8);
                    t2 = parts[1].substring(8);
                    t3=parts[2].substring(10);
                    t4= parts[3].substring(9);
                    t5=parts[4].substring(9);
                    t6= parts[5].substring(8);
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch(MalformedURLException e){
                    e.printStackTrace();
                } catch(IOException e){
                    e.printStackTrace();
                }
            }

            return null;
        }
        @Override
        protected void onPreExecute() {


        }
        @Override
        protected void onPostExecute(String result) {
            textView4.setText(t1);
            textView6.setText(t2);
            textView8.setText(t3);
            textView10.setText(t4);
            textView12.setText(t5);
            textView14.setText(t6);


        }
        @Override
        protected void onProgressUpdate(Void... values) {
            super. onProgressUpdate(values);
        }
    }


}
