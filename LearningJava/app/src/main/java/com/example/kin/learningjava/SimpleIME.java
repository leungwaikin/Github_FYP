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

public class SimpleIME extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    private KeyboardView kv;
    private Keyboard keyboard;

    private boolean caps = false;


    public View onCreateInputView(){
         kv = (KeyboardView)getLayoutInflater().inflate(R.layout.keyboard, null);
         keyboard = new Keyboard(this, R.xml.qwerty);
        kv.setKeyboard(keyboard);
        kv.setOnKeyboardActionListener(this);
        return kv;
    }
    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection ic = getCurrentInputConnection();

        switch(primaryCode){

            case Keyboard.KEYCODE_DELETE :
                ic.deleteSurroundingText(1, 0);
                break;
            case Keyboard.KEYCODE_SHIFT:
                caps = !caps;
                keyboard.setShifted(caps);
                kv.invalidateAllKeys();
                break;
            case Keyboard.KEYCODE_DONE:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            default:
                char code = (char)primaryCode;

                if(code=='1'){
                    ic.commitText(String.valueOf("public"),1);
                }
                if(code=='2'){
                    ic.commitText(String.valueOf("private"),1);
                }
                if(code=='3'){
                    ic.commitText(String.valueOf("void"),1);
                }
                if(code=='4'){
                    ic.commitText(String.valueOf("class"),1);
                }
                if(code=='0'){
                    ic.commitText(String.valueOf("static"),1);
                }

                 if(code=='q') {
                    ic.commitText(String.valueOf("package"),1);
            }
                if(code=='w') {
                ic.commitText(String.valueOf("main"),1);
              }
                if(code=='e') {
                ic.commitText(String.valueOf("{}"),1);
                }
                if(code=='r') {
                 ic.commitText(String.valueOf("()"),1);}

                 if(code=='p') {
                  ic.commitText(String.valueOf("import"),1);}
                if(code=='a') {
                    ic.commitText(String.valueOf("java"),1);}
                if(code=='s') {
                    ic.commitText(String.valueOf("boolean"),1);}
                if(code=='d') {
                    ic.commitText(String.valueOf("int"),1);}
                if(code=='f') {
                    ic.commitText(String.valueOf("float"),1);}
                if(code=='g') {
            ic.commitText(String.valueOf("double"),1);}
                if(code==',') {
                    ic.commitText(String.valueOf(";"),1);}
                if(code=='/') {
                    ic.commitText(String.valueOf("/"),1);}
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
