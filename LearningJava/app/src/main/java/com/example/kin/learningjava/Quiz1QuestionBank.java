package com.example.kin.learningjava;

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Quiz1QuestionBank {

    // declare list of Question objects
    List <Question1> list = new ArrayList<>();
    MyDataBaseHelper1 myDataBaseHelper;

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
        myDataBaseHelper = new MyDataBaseHelper1(context);
        list = myDataBaseHelper.getAllQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestion(new Question1("1. To distribute your application to different platforms, how many Java versions do you need to create?",
                    new String[]{"Just one version", "One for each platform", "Two versions", "No version"}, "Just one version"));
            myDataBaseHelper.addInitialQuestion(new Question1("2. In every Java program...",
                    new String[]{"...there must be a method called \"main\".", "...all of the variables must be integers.", "...there must be at least two variables declared.", "there must be a method output String variable."}, "...there must be a method called "main"."));
            myDataBaseHelper.addInitialQuestion(new Question1("3. Which variable type would you use for a city name?",
                    new String[]{"double", "int", "boolean", "String"}, "String"));
            myDataBaseHelper.addInitialQuestion(new Question("4. You can add a Java doc style comment by using:",
                    new String[]{"// and */ characters to wrap a comment.", "/** and */ characters to wrap a comment.", "/* and */ characters to wrap a comment.", "// characters in the beginning of the line."}, "/** and */ characters to wrap a comment."));
            myDataBaseHelper.addInitialQuestion(new Question("5. What is the result of the following code?\\nint x = 15; int y = 4;\\nint result = x / y;\\nSystem.out.println(result);",
                    new String[]{"3", "3.75", "60", "11"}, "3"));

            list = myDataBaseHelper.getAllQuestionsList();//get list from database again

        }
    }

}