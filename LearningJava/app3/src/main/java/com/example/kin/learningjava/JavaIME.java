package com.example.kin.learningjava;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;

import static android.view.KeyEvent.KEYCODE_1;

/**
 * Created by Lenovo on 19/1/2018.
 */

public class JavaIME extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    private KeyboardView kv;
    private Keyboard keyboard;
    private Keyboard keyboard2;
    private Keyboard keyboard3;
    private Keyboard keyboard4;
    private boolean caps = false;
    private boolean keyBoolean;
    private String keyString;
    private String keyString2;
    private String keyString4;
    private boolean keyCap;


    public View onCreateInputView(){
        kv = (KeyboardView)getLayoutInflater().inflate(R.layout.keyboard, null);
        keyboard = new Keyboard(this, R.xml.qwerty);
        keyboard2 = new Keyboard(this, R.xml.qwerty2);
        keyboard3 =new Keyboard(this, R.xml.qwerty3);
        keyboard4 =new Keyboard(this, R.xml.qwerty4);
        kv.setKeyboard(keyboard);
        kv.setOnKeyboardActionListener(this);
        keyString="1";
        keyCap=false;
        keyBoolean=false;

        return kv;
    }
    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection ic = getCurrentInputConnection();

        switch(primaryCode) {

            case Keyboard.KEYCODE_DELETE:
                ic.deleteSurroundingText(1, 0);
                break;
            case Keyboard.KEYCODE_SHIFT:
                caps = !caps;
                keyboard.setShifted(caps);
                kv.invalidateAllKeys();
                if(caps)
                    kv.setKeyboard(keyboard3);
                else
                    kv.setKeyboard(keyboard2);
                break;
            case Keyboard.KEYCODE_DONE:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            default:
                char code = (char) primaryCode;
//keyboard1
                if (code == '1' && keyString=="1"&&!keyBoolean) {
                    ic.commitText(String.valueOf("public "), 1);
                }
                if (code == '2' && keyString=="1"&&!keyBoolean) {
                    ic.commitText(String.valueOf("private "), 1);
                }
                if (code == '3' && keyString=="1"&&!keyBoolean) {
                    ic.commitText(String.valueOf("void "), 1);
                }
                if (code == '4' && keyString=="1"&&!keyBoolean) {
                    ic.commitText(String.valueOf("class "), 1);
                }
                if (code == '0' && keyString=="1"&&!keyBoolean) {
                    ic.commitText(String.valueOf("static "), 1);
                }

                if (code == 'q' && keyString=="1"&&!keyBoolean) {
                    ic.commitText(String.valueOf("{}"), 1);
                }
                if (code == 'w' && keyString=="1"&&!keyBoolean) {
                    ic.commitText(String.valueOf("()"), 1);
                }
                if (code == 'e' && keyString=="1"&&!keyBoolean) {
                    ic.commitText(String.valueOf("&&"), 1);
                }
                if (code == 'r' && keyString=="1"&&!keyBoolean) {
                    ic.commitText(String.valueOf("||"), 1);
                }

                if (code == 'p' && keyString=="1"&&!keyBoolean) {
                    ic.commitText(String.valueOf("final "), 1);
                }
                if (code == 'a' && keyString=="1"&&!keyBoolean) {
                    ic.commitText(String.valueOf("String "), 1);
                }
                if (code == 's' && keyString=="1"&&!keyBoolean) {
                    ic.commitText(String.valueOf("boolean "), 1);
                }
                if (code == 'd' && keyString=="1"&&!keyBoolean) {
                    ic.commitText(String.valueOf("int "), 1);
                }
                if (code == 'f' && keyString=="1"&&!keyBoolean) {
                    ic.commitText(String.valueOf("float "), 1);
                }
                if (code == 'g'&& keyString=="1"&&!keyBoolean) {
                    ic.commitText(String.valueOf("double "), 1);
                }
                //keyboard2
                if (code == '1' && keyBoolean) {
                    ic.commitText(String.valueOf("public class Main{}"), 1);
                }
                if (code == '2' && keyBoolean) {
                    ic.commitText(String.valueOf("public static void main(String[] args){} "), 1);
                }
                if (code == '3' && keyBoolean) {
                    ic.commitText(String.valueOf("if(){} "), 1);
                }
                if (code == '4' && keyBoolean) {
                    ic.commitText(String.valueOf("else{} "), 1);
                }
                if (code == '0' && keyBoolean) {
                    ic.commitText(String.valueOf("for(){} "), 1);
                }

                if (code == 'q' && keyBoolean) {
                    ic.commitText(String.valueOf("System.out.println();"), 1);
                }
                if (code == 'w' && keyBoolean) {
                    ic.commitText(String.valueOf("try{}catch(Exception e){}"), 1);
                }
                if (code == 'e' && keyBoolean) {
                    ic.commitText(String.valueOf("do{}while();"),1);
                }
                if (code == 'r' && keyBoolean) {
                    ic.commitText(String.valueOf("switch(){}"), 1);
                }

                if (code == 'p' && keyBoolean) {
                    ic.commitText(String.valueOf("public Example(){} "), 1);
                }
                if (code == 'a' && keyBoolean) {
                    ic.commitText(String.valueOf("import java.lang.*; "), 1);
                }
                if (code == 's' && keyBoolean) {
                    ic.commitText(String.valueOf("import java.util.*; "), 1);
                }
                if (code == 'd' && keyBoolean) {
                    ic.commitText(String.valueOf("import java.awt.*; "), 1);
                }
                if (code == 'f' && keyBoolean) {
                    ic.commitText(String.valueOf("import javax.swing.*; "), 1);
                }
                if (code == 'g'&& keyBoolean) {
                    ic.commitText(String.valueOf("import java.io.*; "), 1);
                }

                if (code == '.' && keyString=="1" &&!keyBoolean) {
                    keyString2="1";
                    kv.setKeyboard(keyboard2);
                    keyString="2";
                    break;
                }
                if (code == 'm' && keyString=="1") {
                    keyBoolean = true;
                    kv.setKeyboard(keyboard4);
                }
                if (code == '.' && keyBoolean) {
                    keyBoolean = false;
                    kv.setKeyboard(keyboard);
                }
                if (code == ',' && keyString=="1") {
                    ic.commitText(String.valueOf(";"), 1);
                }
                if (code == ' ' && keyString=="1") {
                    ic.commitText(String.valueOf(" "), 1);
                }
                if (Character.isLetter(code) && caps) {
                    code = Character.toUpperCase(code);

                }
                if (code == '/' && keyString=="2") {
                    keyString2="2";
                    keyString="1";
                    kv.setKeyboard(keyboard);
                }
                if (code=='#'&&keyString=="2"&& keyString2=="1") {
                    ic.commitText(String.valueOf("/* */"), 1);
                    break;
                }

                if (keyString=="2"&& keyString2=="1") {
                    ic.commitText(String.valueOf(code), 1);
                }
        }

    }   @Override
    public void onPress(int primaryCode) {
    }

    @Override
    public void onRelease(int primaryCode) {
    }

    @Override
    public void onText(CharSequence text) {
    }

    @Override
    public void swipeDown() {
    }

    @Override
    public void swipeLeft() {
    }

    @Override
    public void swipeRight() {
    }

    @Override
    public void swipeUp() {
    }
}
