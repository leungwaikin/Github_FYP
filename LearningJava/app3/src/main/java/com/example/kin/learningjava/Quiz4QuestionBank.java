package com.example.kin.learningjava;

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Quiz4QuestionBank {

    // declare list of Question objects
    List <Question1> list = new ArrayList<>();
    MyDataBaseHelper4 myDataBaseHelper;

    // method returns number of questions in list
    public int getLength(){
        return list.size();
    }

    // method returns question from list based on list index
    public String getQuestion(int a) {
        return list.get(a).getQuestion();
    }

    // method return a single multiple choice item for question based on list index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4
    // as an argument
    public String getChoice(int index, int num) {
        return list.get(index).getChoice(num-1);
    }

    //  method returns correct answer for the question based on list index
    public String getCorrectAnswer(int a) {
        return list.get(a).getAnswer();
    }



    public void initQuestions(Context context) {
        myDataBaseHelper = new MyDataBaseHelper4(context);
        list = myDataBaseHelper.getAllQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestion(new Question1("1. What would the name of the setter method for the class variable named \"age\" be?",
                    new String[]{"initAge", "setAge", "getAge", "Age"}, "setAge"));
            myDataBaseHelper.addInitialQuestion(new Question1("2. What is the value of the following expression?\nMath.abs(Math.min(-6, 3));",
                    new String[]{"-6", "6", "3", "-3"}, "6"));
            myDataBaseHelper.addInitialQuestion(new Question1("3. Which access modifier explicitly says that a method or variable of an object can be accessed by code from outside of the class of that object?",
                    new String[]{"private", "static", "public", "default"}, "public"));
            myDataBaseHelper.addInitialQuestion(new Question1("4. What keyword makes a variable a constant?",
                    new String[]{"static ", "final", "void", "Constant"}, "final"));
            myDataBaseHelper.addInitialQuestion(new Question1("5. How many times can you call a method?",
                    new String[]{"zero", "one", "only two", "as many as you want"}, "as many as you want"));

            list = myDataBaseHelper.getAllQuestionsList();//get list from database again

        }
    }

}