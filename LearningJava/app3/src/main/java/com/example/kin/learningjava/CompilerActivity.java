package com.example.kin.learningjava;

        import android.app.AlertDialog;
        import android.content.Context;
        import android.content.DialogInterface;
        import android.content.res.Resources;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.text.method.ScrollingMovementMethod;
        import android.view.View;
        import android.view.ViewTreeObserver;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;


public class CompilerActivity extends AppCompatActivity {
    String className=" ";
    CompilerFileHelper CFH;
    final Context context = this;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compiler2);



        final TextView input = (TextView) findViewById(R.id.input);

        input.setMovementMethod(new ScrollingMovementMethod());

        Bundle extras = getIntent().getExtras();


        final TextView nLine = (TextView) findViewById(R.id.nLine);
        nLine.setMovementMethod(new ScrollingMovementMethod());
        input.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int scrollY = input.getScrollY();
                nLine.scrollTo(0, scrollY);
            }
        });

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int lines = input.getLineCount();
                String linesText = "";
                for (int z = 1; z <= lines; z++) {
                    linesText = linesText + z + "\n";
                }
                nLine.setText(linesText);
            }


            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int lines = input.getLineCount();
                String linesText = "";
                for (int z = 1; z <= lines; z++) {
                    linesText = linesText + z + "\n";
                }
                nLine.setText(linesText);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        final EditText ncName = new EditText(this);



            final Button help= (Button) findViewById(R.id.help);
            help.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
                    builder.setView(R.layout.compiler_help);
                   /* TextView title_of_dialog = new TextView(getApplicationContext());
                    title_of_dialog.setTextSize(25);
                    title_of_dialog.setText("How to use the compiler ? ");
                    builder.setCustomTitle(title_of_dialog);*/
                   builder.setTitle("How to use the compiler ? ");
                    final android.support.v7.app.AlertDialog dialog = builder.create();

                    dialog.show();
                }
            });
            Button compile = (Button) findViewById(R.id.Compile);
            compile.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    compiler(input.getText().toString());
                }
            });

            final TextViewUndoRedo mTextViewUndoRedo = new TextViewUndoRedo(input);
            Button undo = (Button) findViewById(R.id.Undo);
            undo.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mTextViewUndoRedo.undo();
                }
            });

            Button redo = (Button) findViewById(R.id.Redo);
            redo.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mTextViewUndoRedo.redo();
                }
            });



    }



    public void compiler(String uInput){
        CFH=new CompilerFileHelper(className, this, uInput);
        CFH.copyAndCreateFile();
        String[] result=CFH.compiler();
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
        TextView title = new TextView(context);
        builder.setView(R.layout.compiler_output);
        final android.support.v7.app.AlertDialog dialog = builder.create();
        dialog.show();
        final TextView output = (TextView) dialog.findViewById(R.id.output);
        final TextView error = (TextView) dialog.findViewById(R.id.errorlog);
        output.setMovementMethod(new ScrollingMovementMethod());
        error.setMovementMethod(new ScrollingMovementMethod());

        output.setText(result[0]);


       error.setText(result[1]);


    }







}
