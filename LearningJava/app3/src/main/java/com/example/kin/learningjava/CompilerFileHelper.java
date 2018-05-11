package com.example.kin.learningjava;



        import android.content.Context;

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


public class CompilerFileHelper {
    String className;
    Context myContext;
    String input;
    File storage;
    String error;
    String result;
    String[] record=new String[2];

    public CompilerFileHelper(String name, Context context, String input){
        this.className=name;
        myContext=context;
        this.input=input;
        storage = myContext.getDir("all41", Context.MODE_PRIVATE);
    }


    public void copyAndCreateFile() {

        BufferedInputStream bis = null;
        OutputStream dexWriter = null;
        int BUF_SIZE = 8 * 1024;

        try {
            bis = new BufferedInputStream(myContext.getAssets().open("android.jar"));
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
                    new FileOutputStream( storage.getAbsolutePath() + "/Main.java"));
            byte[] buf = new byte[BUF_SIZE];
            String buff=input;
            dexWriter.write(buff.getBytes());
            dexWriter.close();
        } catch (Exception e) {
            System.err.println("Error while copying from assets: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String[] compiler(){
        System.err.println("copying the android.jar from asssets to the internal storage to make it available to the compiler");
        System.err.println("instantiating the compiler and compiling the java file");
        try {
            StringWriter writer= new StringWriter();
            PrintWriter pw =new PrintWriter(writer);
            org.eclipse.jdt.internal.compiler.batch.Main ecjMain = new org.eclipse.jdt.internal.compiler.batch.Main(new PrintWriter(System.out), pw, false/*noSystemExit*/, null);
            ecjMain.compile(new String[]{"-classpath", storage.getAbsolutePath() + "/android.jar", storage.getAbsolutePath() + "/Main.java"});
            error=writer.toString();
        }catch (Exception e) {
            System.err.println("Error while copying from assets: " + e.getMessage());
            e.printStackTrace();
        }

        System.err.println("calling DEX and dexifying the test class");
        com.android.dx.command.Main.main(new String[] {"--dex", "--output=" + storage.getAbsolutePath() + "/Main.jar", storage.getAbsolutePath() + "/./Main.class"});


        try{
            Runtime rt=Runtime.getRuntime();
            Process proc=rt.exec("dalvikvm -cp"+" "+ storage.getAbsolutePath() +  "/Main.jar"+" "+"Main");
            InputStream stderr = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(stderr);
            BufferedReader br = new BufferedReader(isr);
            String line = null;

            while ( (line = br.readLine()) != null)
                result=line;

            int exitVal = proc.waitFor();
            System.out.println("Process exitValue: " + exitVal);

        }catch (Exception e) {
            System.err.println("Error while executing command: " + e.getMessage());
            e.printStackTrace();
        }

        if(!error.isEmpty()){
            record[1]=error;

        }
        record[0]=result;
        return record;
    }


}
