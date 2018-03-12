package com.example.kin.learningjava;

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Quiz5QuestionBank {

    // declare list of Question objects
    List <Question1> list = new ArrayList<>();
    MyDataBaseHelper5 myDataBaseHelper;

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
        myDataBaseHelper = new MyDataBaseHelper5(context);
        list = myDataBaseHelper.getAllQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestion(new Question1("1. Object variables store...",
                    new String[]{"Classes", "Objects", "String", "References"}, "References"));
            myDataBaseHelper.addInitialQuestion(new Question1("2.In Java, how many superclasses can your inherited subclass have?",
                    new String[]{"multiple", "none", "only two", "only one"}, "only one"));
            myDataBaseHelper.addInitialQuestion(new Question1("3. Polymorphism is...",
                    new String[]{"... one method, with one implementation", "... one method, with different implementations", "... each implementation, with a different method", "... one implementation, with different methods"}, "... one method, with different implementations"));
            myDataBaseHelper.addInitialQuestion(new Question1("4. What is the output of this code?\nclass A {\nprivate void print() {System.out.println(''a'');}\nprivate void print(String str) {System.out.println(''b'');}\nprivate void print(int x) {System.out.println(''c'');}\n		public static void main(String[ ] args) {\n	     A object = new A();\n     object.print(12);}\n}",
                    new String[]{"a", "b", "c", "12"}, "c"));
           myDataBaseHelper.addInitialQuestion(new Question1("5. What term is used for hiding the details of an object from the other parts of a program?",
                    new String[]{"Polymorphism", "Inheritance", "Encapsulation", "Data Mining"}, "Encapsulation"));

            list = myDataBaseHelper.getAllQuestionsList();//get list from database again

        }
    }

}