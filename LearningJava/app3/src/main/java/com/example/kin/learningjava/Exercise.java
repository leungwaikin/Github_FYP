package com.example.kin.learningjava;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Picture;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
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
        categories.add("Q1.1: Run and execute the default program");
        categories.add("Q1.2: Write a program printing out \"Java is amazing\" ");
        categories.add("Q1.3: Use multi-line comments to describe the function of System.out.println");
        categories.add("Q1.4: Write two variables to store and print \"String \" &  20.5");
        categories.add("Q1.5: Write a program printing out the sum of 7+8 ( x + y )");
        categories.add("Q1.6: Write a program and initialize the variables x & y to 10 , printing out x++ and ++y. Explain the difference ");
        categories.add("Q1.7: Write a program and print out a string using String Concantenation ");
        categories.add("Q1.8: Write a program to get input \"Java\" ");
        categories.add("Q1.9: Write a program with a method to return the maximum of two numbers ");
        categories.add("Q2.1: Write a program to get a user input, if the input is higher than 5 , print \"too large \" (assume that the input is an integer)");
        categories.add("Q2.2: According to above question , when the input is higher than 5 , print  \"too large \" ,otherwise print  \"too small \" ");
        categories.add("Q2.3: Using else-if statement to evalute the smallest value of two numbers");
        categories.add("Q2.4: Using NOT operator to evalute a variable is not larger than 10");
        categories.add("Q2.5: Find the output of the program");
        categories.add("Q2.6:");
        categories.add("Q2.7:Using for loop to print out 1 to 10");
        categories.add("Q2.8:Modify the answer of previous question to print out 1 to 10 using do-while loop (Hints: Using Increment inside the loop");
        categories.add("Q3.1:Write a program to initialize an array with \'H\' , \'E\',\'L\',\'L\',\'O\' (Hints:Use character array) ");
        categories.add("Q3.2:");
        categories.add("Q3.3: Write a program to print the elements from an array {0,1,2,3,4,5}  using enhanced for loop ");
        categories.add("Q3.4:");
        categories.add("Q4.1:What is the function of constructor");
        categories.add("Q4.2: ");
        categories.add("Q4.3: ");
        categories.add("Q4.4: ");
        categories.add("Q4.5: ");
        categories.add("Q4.6: ");
        categories.add("Q4.7: Write a main class program to set age attribute to 20 using the constuctor (Hints: The constructor could take one parameter)");
        categories.add("Q4.8: ");
        categories.add("Q4.9: Write a program to print the minimun value of two variable using Math class");
        categories.add("Q4.10: ");
        categories.add("Q4.11: ");
        categories.add("Q4.12: ");




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
        //String url = "https://repl.it/@steveysh/UnsightlyMetallicAdministrator";
        mwebview.loadUrl("https://repl.it/repls/NoteworthyIdenticalSpheres");

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
                if (spinner.getSelectedItem().toString().length() > 50 && spinner.getSelectedItem().toString().length() <= 100) {
                    title.setTextSize(15);
                } else if (spinner.getSelectedItem().toString().length() <= 50) {
                    title.setTextSize(20);
                } else if (spinner.getSelectedItem().toString().length() > 100) {
                    title.setTextSize(15);
                }
                title.setText(spinner.getSelectedItem().toString() + ".");
                title.setPadding(5, 5, 0, 0);
                title.setTextColor(-16777216);
// 2. Chain together various setter methods to set the dialog characteristics

                builder.setView(R.layout.exercisequestion);
                builder.setTitle(spinner.getSelectedItem().toString());
                builder.setCustomTitle(title);
              /*  if(spinner.getSelectedItemPosition()==14){
                    builder.setView(R.layout.exercisequestion2);
                    //builder.setTitle(spinner.getSelectedItem().toString());
                    builder.setCustomTitle(title);
                }*/


// 3. Get the AlertDialog from create()
                if (spinner.getSelectedItemPosition()==13||spinner.getSelectedItemPosition()==14||spinner.getSelectedItemPosition()==18||spinner.getSelectedItemPosition()==20||spinner.getSelectedItemPosition()==22||spinner.getSelectedItemPosition()==23||spinner.getSelectedItemPosition()==24||spinner.getSelectedItemPosition()==25||spinner.getSelectedItemPosition()==26) {
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(context);
                    builder2.setView(R.layout.exercisequestion2);
                    builder2.setTitle(spinner.getSelectedItem().toString());
                    builder2.setCustomTitle(title);
                    final AlertDialog dialog2 = builder2.create();

                    dialog2.show();
                    String[] exercises = context.getResources().getStringArray(R.array.exercises);
                    final TextView text2 = (TextView) dialog2.findViewById(R.id.textView17);

                    for (int i = 0; i <= exercises.length; i++) {
                        if (spinner.getSelectedItemPosition() == 13 || spinner.getSelectedItemPosition() == 14 || spinner.getSelectedItemPosition() == 18 || spinner.getSelectedItemPosition() == 20 || spinner.getSelectedItemPosition() == 22 || spinner.getSelectedItemPosition() == 23 || spinner.getSelectedItemPosition() == 24 || spinner.getSelectedItemPosition() == 25 || spinner.getSelectedItemPosition() == 26) {
                            if (spinner.getSelectedItemPosition() == i) {
                                        text2.setText(exercises[i]);
                                        text2.setTextSize(22);

                            }
                        }
                    }


                    final Button dialogButton11 = (Button) dialog2.findViewById(R.id.dialogButtonSubmit);
                    final EditText input1 = (EditText) dialog2.findViewById(R.id.editText5);
                    dialogButton11.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String input11 = input1.getText().toString();
                            String ans11=context.getResources().getString(R.string.Q2_5);

                            text2.setText(text2.getText().toString().replace("______",ans11));
                            dialogButton11.setEnabled(false);
                            if(input11.equals(ans11)) {
                               /* Spannable ans = new SpannableString(ans11);
                                SpannableStringBuilder builder = new SpannableStringBuilder();

                                ans.setSpan(new ForegroundColorSpan(Color.RED), 0, ans.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                builder.append(ans);*/

                                input1.setText(input11+"(Correct)");
                                input1.setTextColor(Color.rgb(0,255,0));
                            }
                            if(!input11.equals(ans11)) {
                               /* Spannable ans = new SpannableString(ans11);
                                SpannableStringBuilder builder = new SpannableStringBuilder();

                                ans.setSpan(new ForegroundColorSpan(Color.RED), 0, ans.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                builder.append(ans);*/

                                input1.setText(input11+"(Incorrect)");
                                input1.setTextColor(Color.rgb(255,0,0));
                            }
                        }
                    });




                }
                else {
                    final AlertDialog dialog = builder.create();
                    dialog.show();
                    final TextView text = (TextView) dialog.findViewById(R.id.textView15);
                    String[] exercises = context.getResources().getStringArray(R.array.exercises);
                    final Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                    final Button dialogButton2 = (Button) dialog.findViewById(R.id.dialogButtonCopy);
                    final Button dialogButton3 = (Button) dialog.findViewById(R.id.dialogButtonShow);


                /*final TextView text2 = (TextView) dialog.findViewById(R.id.textView17);
               final Button dialogButton11 =  (Button) dialog.findViewById(R.id.dialogButtonSubmit);
               final EditText input1 = (EditText) dialog.findViewById(R.id.editText5);*/

                    dialogButton2.setEnabled(false);
                   /* for(int i=0;i<=exercises.length;i++){
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
              }*/

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
                            Toast.makeText(context, "Answer is copied",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
                    //btn3
                    dialogButton3.setOnClickListener(new View.OnClickListener() {
                        String[] exercises = context.getResources().getStringArray(R.array.exercises);

                        @Override
                        public void onClick(View v) {
                            for (int i = 0; i <= exercises.length; i++) {
                                if (spinner.getSelectedItemPosition() == i) {
                                    if (!exercises[i].equals("")) {
                                        if (text.getText().equals("")) {
                                            text.setText(exercises[i]);

                                            dialogButton2.setEnabled(true);
                                            dialogButton3.setEnabled(false);
                                        }
                                    } else if (exercises[i].equals("")) {
                                        text.setText("(No answer)");
                                        dialogButton2.setEnabled(false);
                                    } else if (!text.getText().equals("")) {
                                        text.setText("");
                                        dialogButton3.setEnabled(false);
                                    }


                                }
                            }
                        }
                    });
                }


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

