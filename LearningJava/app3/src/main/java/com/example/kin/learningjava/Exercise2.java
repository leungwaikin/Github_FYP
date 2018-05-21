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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class Exercise2 extends AppCompatActivity {
    WebView mwebview;
    String name;
    final Context context = this;
    Button offlinecompiler;
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
        categories.add("Q1_1: Run and execute the default program");
        categories.add("Q1_2: Write a program printing out \"Java is amazing\" ");
        categories.add("Q1_3: Use multi-line comments to describe the function of System.out.println");
        categories.add("Q1_4: Write two variables to store and print \"String \" &  20.5");
        categories.add("Q1_5: Write a program printing out the sum of 7+8 ( x + y )");
        categories.add("Q1_6: Write a program and initialize the variables x & y to 10 , printing out x++ and ++y. Explain the difference ");
        categories.add("Q1_7: Write a program and print out a string using String Concantenation ");
        categories.add("Q1_8: Write a program to get input \"Java\" ");
        categories.add("Q1_9: Write a program with a method to return the maximum of two numbers ");

        categories.add("Q2_1: Write a program to get a user input, if the input is higher than 5 , print \"too large \" (assume that the input is an integer)");
        categories.add("Q2_2: According to above question , when the input is higher than 5 , print  \"too large \" ,otherwise print  \"too small \" ");
        categories.add("Q2_3: Using else-if statement to evalute the smallest value of two numbers");
        categories.add("Q2_4: Using NOT operator to evalute a variable is not larger than 10");
        categories.add("Q2_5: Find the output of the switch while-loop program ");
        categories.add("Q2_6: Find the output of the for-loop program");
        categories.add("Q2_7: Using for loop to print out 1 to 10");
        categories.add("Q2_8: Modify the answer of previous question to print out 1 to 10 using do-while loop (Hints: Using Increment inside the loop");

        categories.add("Q3_1: Write a program to initialize an array with \'H\' , \'E\',\'L\',\'L\',\'O\' (Hints:Use character array) ");
        categories.add("Q3_2: Find the output of the array program");
        categories.add("Q3_3: Write a program to print the elements from an array {0,1,2,3,4,5}  using enhanced for loop ");
        categories.add("Q3_4: Find the output of the multidimensional array program");

        categories.add("Q4_1: What is the function of constructor");
        categories.add("Q4_2: Fill in the blank to complete the program");
        categories.add("Q4_3: Fill in the blank to complete the program");
        categories.add("Q4_4: Fill in the blank to complete the program(declare the color attribute to \"yello\" and age attribute to 4 ");
        categories.add("Q4_5: Write down the characteristic(s) of \"protected\" access modifier");
        categories.add("Q4_6: Write a getter method for the program(Beaware of wordings)");
        categories.add("Q4_7: Write a main class program to set age attribute to 20 using the constuctor (Hints: The constructor could take one parameter)");
        categories.add("Q4_8: Find the output of the program");
        categories.add("Q4_9: Write a program to print the minimun value of two variable using Math class");
        categories.add("Q4_J: List one restriction of using static method ");
        categories.add("Q4_K: Write down  the characteristic(s) of \"final\" ");
        categories.add("Q4_L: Write down the import statement so as to import a class named Simple ");

        categories.add("Q5_1: Fill in the blank so that the program can achieve encapsulation");
        categories.add("Q5_2: FIll in the blank to create a subclass");
        categories.add("Q5_3: Write down the output of the program");
        categories.add("Q5_4: Fill in the blank of the following statement");
        categories.add("Q5_5: Fill in the blank of the abstract class");
        categories.add("Q5_6: State whether the following fragmented code is correct or wrong");
        categories.add("Q5_7: Complete the following fragmented code of type casting");
        categories.add("Q5_8: State the following fragmented code is upcasting of downcasting");
        categories.add("Q5_9: Write down the output of the anonymous class program");
        categories.add("Q5_J: Write down the output of the inner class program");
        categories.add("Q5_K: Evalute the following program return true or false");
        categories.add("Q5_L: Complete the program to print out the according output");
        categories.add("Q5_M: Write the import statement that the package is mainly for creating user interfaces and for painting graphics and images");

        categories.add("Q6_1: State the difference(s) between \"throw\" and \"throws\" ");
        categories.add("Q6_2: Fill in the blank to complete the Thread program");
        categories.add("Q6_3: Write the output of the program");
        categories.add("Q6_4: Between ArrayList and LinkList, state which one is better for storage , which one is better for manipulation");
        categories.add("Q6_5: Write down the output of the HashMap program");
        categories.add("Q6_6: Write down the output of the HashSet program");
        categories.add("Q6_7: Write down the output of the sorted list");
        categories.add("Q6_8: Complete the program to print out the according output");
        categories.add("Q6_9: Write down the method which can check whether a file exists before working on file");
        categories.add("Q6_J: Fill in the blank to complete the I/O program ");
        categories.add("Q6_K: Fill in the blank to complete the file formatter program ");


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
        mwebview.loadUrl("https://repl.it/@javalearner2/NormalWrathfulHarddrive");
        //mwebview.loadUrl("https://repl.it/repls/compilework");
        mwebview.loadUrl("javascript:(function() { " +
                "var head = document.getElementsByClassName('jsx-96056714 wrapper').style.display='none'; " +
                "})()");
        mwebview.getSettings().setUseWideViewPort(true);
        mwebview.getSettings().setLoadWithOverviewMode(true);
        offlinecompiler=(Button)findViewById(R.id.offlinecompiler);
        offlinecompiler.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent jumpage=new Intent(Exercise2.this,CompilerActivity.class);
                startActivity(jumpage);
            }
        });
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
                    title.setTextSize(20);
                } else if (spinner.getSelectedItem().toString().length() <= 50) {
                    title.setTextSize(25);
                } else if (spinner.getSelectedItem().toString().length() > 100) {
                    title.setTextSize(20);
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


// 3. Get the AlertDialog from create() 25 is Q4_5
                if (spinner.getSelectedItemPosition()==13||spinner.getSelectedItemPosition()==14||spinner.getSelectedItemPosition()==18||spinner.getSelectedItemPosition()==20||spinner.getSelectedItemPosition()==22||spinner.getSelectedItemPosition()==23||spinner.getSelectedItemPosition()==24||spinner.getSelectedItemPosition()==26||spinner.getSelectedItemPosition()==28||spinner.getSelectedItemPosition()>=32&&!(spinner.getSelectedItemPosition()==46)&&!(spinner.getSelectedItemPosition()==49)) {
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(context);
                    builder2.setView(R.layout.exercisequestion2);
                    builder2.setTitle(spinner.getSelectedItem().toString());
                    builder2.setCustomTitle(title);
                    final AlertDialog dialog2 = builder2.create();

                    dialog2.show();
                    String[] exercises = context.getResources().getStringArray(R.array.exercises);
                    final TextView text2 = (TextView) dialog2.findViewById(R.id.textView17);
//Q5_2 34 Q6_1 46
                    for (int i = 0; i <= exercises.length; i++) {
                        if (spinner.getSelectedItemPosition() == 13 || spinner.getSelectedItemPosition() == 14 || spinner.getSelectedItemPosition() == 18 || spinner.getSelectedItemPosition() == 20 || spinner.getSelectedItemPosition() == 22 || spinner.getSelectedItemPosition() == 23 || spinner.getSelectedItemPosition() == 24  || spinner.getSelectedItemPosition() == 26||spinner.getSelectedItemPosition()==28||spinner.getSelectedItemPosition()>=32&&!(spinner.getSelectedItemPosition()==46)&&!(spinner.getSelectedItemPosition()==49)) {
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
                            String inputOrginal = input1.getText().toString();
                            String input10 = input1.getText().toString().replaceAll("\n","");
                            String input11 = input10.toString().replaceAll(" ","");
                            String question = spinner.getSelectedItem().toString().substring(0,4);
                            String[] anarray=context.getResources().getStringArray(R.array.model);
                            String ans11="";
                            for(String ans:anarray) {
                                if (question.equals(ans.substring(0, 4))) {
                                    ans11 = ans.substring(4);

                                }
                            }
                            String ans12 = ans11.toString().replaceAll(" ","");
                            //text2.setText(text2.getText().toString().replace("______", " "+ans12));
                            //input1.setText(input11);
                            //text2.setText(text2.getText().toString().replace("______", anarray.toString()));
                            dialogButton11.setEnabled(false);
                            if(input11.equals(""+ans12)) {
                                text2.setText(text2.getText().toString().replace("______", ans11));
                               /* Spannable ans = new SpannableString(ans11);
                                SpannableStringBuilder builder = new SpannableStringBuilder();

                                ans.setSpan(new ForegroundColorSpan(Color.RED), 0, ans.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                builder.append(ans);*/

                                input1.setText(inputOrginal+"(Correct)");
                                input1.setTextColor(Color.rgb(0,255,0));
                                input1.setEnabled(false);
                            }
                            if(!input11.equals(ans12)) {
                               /* Spannable ans = new SpannableString(ans11);
                                SpannableStringBuilder builder = new SpannableStringBuilder();

                                ans.setSpan(new ForegroundColorSpan(Color.RED), 0, ans.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                builder.append(ans);*/

                                input1.setHint(inputOrginal+"(Incorrect)");
                                dialogButton11.setEnabled(true);
                              //  text2.setText(text2.getText().toString().replace(ans11,"______"));
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

