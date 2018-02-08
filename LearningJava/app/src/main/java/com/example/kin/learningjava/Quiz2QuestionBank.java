package com.example.kin.learningjava;

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Quiz2QuestionBank {

    // declare list of Question objects
    List <Question1> list = new ArrayList<>();
    MyDataBaseHelper2 myDataBaseHelper;

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
        myDataBaseHelper = new MyDataBaseHelper2(context);
        list = myDataBaseHelper.getAllQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestion(new Question1("1. An if statement can contain how many else if statements?",
                    new String[]{"None", "Only two", "Only one", "As many as you want"}, "As many as you want"));
            myDataBaseHelper.addInitialQuestion(new Question1("2. What is the output of the following code?\\nint a = 11; int b = 12; int c = 40;\\nswitch (a) {\\n case 40:\\n   System.out.println(b);\\n   break;\\n default:\\n   System.out.println(c);\\n}\\n",
                    new String[]{"11", "12", "40", "52"}, "40"));
            myDataBaseHelper.addInitialQuestion(new Question1("3. How is a do while loop different from a while loop?",
                    new String[]{"There are no different.", "A do while loop runs your code at least one time.", "A while loop runs the code before testing the condition.", "A do while loop tests the condition before running the code."}, "A do while loop runs your code at least one time."));
            myDataBaseHelper.addInitialQuestion(new Question1("4. Choose a statement to fill in the blanks to print \"in a loop\" 5 times using the for loop.",
                    new String[]{"reusable GUI element", "Layout for Activity", "device placed in cans of beer", "build toolkit"}, "reusable GUI element. \\n __(int x = 0; x < 5; x++) { \\n  System.out.println(\"in a loop\");}"));
            myDataBaseHelper.addInitialQuestion(new Question1("5. How many times will the following loop run?\\nfor (int i = 2; i < 10; i = i*i) {\\n  System.out.println(i);\\n}",
                    new String[]{"2", "10", "2", "4"}, "2"));

            list = myDataBaseHelper.getAllQuestionsList();//get list from database again

        }
    }

}