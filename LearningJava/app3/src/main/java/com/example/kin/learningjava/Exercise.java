package com.example.kin.learningjava;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Picture;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Exercise extends AppCompatActivity {
    WebView mwebview;
    String name;
    final Context context = this;

    //String[] albums = getResources().getStringArray(R.array.exercises);
   // Resources res = getResources();
  //  String[]  exercises = res.getStringArray(R.array.exercises);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        Spinner spinner = (Spinner) findViewById(R.id.simpleSpinner);
        String[] exercises = context.getResources().getStringArray(R.array.exercises);
        // Spinner click listener
       // spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Q1-1: Run and execute the default program");
        categories.add("Q1-2: Write a program printing out \"Java is amazing\" ");
        categories.add("Q1-3: Use multi-line comments to describe the function of System.out.println");
        categories.add("Q1-4: Write two variables to store and print \"String \" &  20.5");
        categories.add("Q1-5: Write a program printing out the sum of 7+8 ( x + y )");
        categories.add("Q1-6: Write a program and initialize the variables x & y to 10 , printing out x++ and ++y. Explain the difference ");
        categories.add("Q1-7: Write a program and print out a string using String Concantenation ");
        categories.add("Q1-8: Write a program to get input \"Java\" ");
        categories.add("Q1-9: Write a program with a method to return the maximum of two numbers ");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        addListenerOnButton();
        Bundle bundle=getIntent().getExtras();
        name=bundle.getString("username");
        mwebview = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = mwebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //mwebview.getSettings().setBuiltInZoomControls(true);
        mwebview.setInitialScale(1);
        String url="https://repl.it/repls/SnivelingSubmissiveRepo";
        mwebview.loadUrl(url);

       /* mwebview.loadUrl("javascript:(function() { " +
                "var head = document.getElementsByClassName('header').style.display='none'; " +
                "})()");*/
        mwebview.getSettings().setUseWideViewPort(true);
        mwebview.getSettings().setLoadWithOverviewMode(true);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it

    }



    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {

    }


    public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub

    }
    // get the selected dropdown list value
    public void addListenerOnButton() {

       final  Spinner spinner = (Spinner) findViewById(R.id.simpleSpinner);
        Button btnSubmit = (Button) findViewById(R.id.getAnswer);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                TextView title = new TextView(context);
                title.setTextSize(15);
                title.setText(spinner.getSelectedItem().toString()+".");
// 2. Chain together various setter methods to set the dialog characteristics
                builder.setView(R.layout.exercisequestion);
                //builder.setTitle(spinner.getSelectedItem().toString());
                builder.setCustomTitle(title);




// 3. Get the AlertDialog from create()
                final AlertDialog dialog = builder.create();
                dialog.show();
               final TextView text = (TextView) dialog.findViewById(R.id.textView15);
                String[] exercises = context.getResources().getStringArray(R.array.exercises);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                Button dialogButton2 = (Button) dialog.findViewById(R.id.dialogButtonCopy);

                    for(int i=0;i<=exercises.length;i++){
              if(spinner.getSelectedItemPosition()==i) {
                  if(!exercises[i].equals("")) {
                      text.setText(exercises[i]);
                      dialogButton2.setEnabled(true);
                  }
                  else {
                      text.setText("(No answer)");
                      dialogButton2.setEnabled(false);
                  }


              }
              }

                // if button is clicked, close the custom dialog
               dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialogButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                        String getstring = text.getText().toString();
                        android.content.ClipData clip = android.content.ClipData
                                .newPlainText("Your OTP", getstring);
                        clipboard.setPrimaryClip(clip);
                        dialog.dismiss();
                        Toast.makeText(context,"Answer is copied",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


    //Performing action onItemSelected and onNothing selected


        /*Intent in;
        in = new Intent(Exercise.this,DialogNewClass.class);
        Bundle bundle = new Bundle();
        bundle.putString("username",name);
        in.putExtras(bundle);
        startActivity(in);*/

    }

