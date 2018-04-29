package com.example.kin.learningjava;


import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import dalvik.system.DexClassLoader;


public class CompilerActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_compiler);


        final TextView output= (TextView) findViewById(R.id.output);
        final TextView input= (TextView) findViewById(R.id.input);
        final TextView error= (TextView) findViewById(R.id.error);
        input.setMovementMethod(new ScrollingMovementMethod());
        output.setMovementMethod(new ScrollingMovementMethod());
        error.setMovementMethod(new ScrollingMovementMethod());


        Button compile= (Button) findViewById(R.id.Compile);
        compile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                compiler(input,output,error);
            }
        });

    }



    public void compiler(TextView input,TextView output,TextView error){
        File storage = getDir("all41", Context.MODE_PRIVATE);

        System.err.println("copying the android.jar from asssets to the internal storage to make it available to the compiler");
        BufferedInputStream bis = null;
        OutputStream dexWriter = null;
        int BUF_SIZE = 8 * 1024;

        try {
            bis = new BufferedInputStream(getAssets().open("android.jar"));
            dexWriter = new BufferedOutputStream(
                    new FileOutputStream(storage.getAbsolutePath() + "/android.jar"));
            byte[] buf = new byte[BUF_SIZE];
            int len;
            while((len = bis.read(buf, 0, BUF_SIZE)) > 0) {
                dexWriter.write(buf, 0, len);
            }
            dexWriter.close();
            bis.close();

        } catch (Exception e) {
            System.err.println("Error while copying from assets: " + e.getMessage());
            e.printStackTrace();
        }


        try {
            dexWriter = new BufferedOutputStream(
                    new FileOutputStream( storage.getAbsolutePath() + "/"+"Main"+".java"));
            byte[] buf = new byte[BUF_SIZE];
            String buff=input.getText().toString();
            dexWriter.write(buff.getBytes());

            dexWriter.close();
        } catch (Exception e) {
            System.err.println("Error while copying from assets: " + e.getMessage());
            e.printStackTrace();
        }


        System.err.println("instantiating the compiler and compiling the java file");
        try {
            StringWriter writer= new StringWriter();
            PrintWriter pw =new PrintWriter(writer);
            org.eclipse.jdt.internal.compiler.batch.Main ecjMain = new org.eclipse.jdt.internal.compiler.batch.Main(new PrintWriter(System.out), pw, false/*noSystemExit*/, null);
            ecjMain.compile(new String[]{"-classpath", storage.getAbsolutePath() + "/android.jar", storage.getAbsolutePath() + "/" + "Main" + ".java"});
            error.setText(writer.toString());
        }catch (Exception e) {
            System.err.println("Error while copying from assets: " + e.getMessage());
            e.printStackTrace();
        }

        System.err.println("calling DEX and dexifying the test class");
        com.android.dx.command.Main.main(new String[] {"--dex", "--output=" + storage.getAbsolutePath() + "/"+"Main"+".jar", storage.getAbsolutePath() + "/./"+"Main"+".class"});

        System.err.println("instantiating DexClassLoader, loading class and invoking toString()");
        DexClassLoader cl = new DexClassLoader(storage.getAbsolutePath() +  "/"+"Main"+".jar", storage.getAbsolutePath(), null, getClassLoader());

        File aa=new File(storage.getAbsolutePath() + "/"+"Main"+".jar");



        try{
            Runtime rt=Runtime.getRuntime();
            Process proc=rt.exec("dalvikvm -cp"+" "+ storage.getAbsolutePath() +  "/"+"Main"+".jar"+" "+"Main");
            InputStream stderr = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(stderr);
            BufferedReader br = new BufferedReader(isr);
            String line = null;

            while ( (line = br.readLine()) != null)
            {output.setText(line); }
            int exitVal = proc.waitFor();
            System.out.println("Process exitValue: " + exitVal);

        }catch (Exception e) {
            System.err.println("Error while executing command: " + e.getMessage());
            e.printStackTrace();
        }




    }






}
