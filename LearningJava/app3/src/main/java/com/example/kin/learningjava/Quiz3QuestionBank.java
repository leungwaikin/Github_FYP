package com.example.kin.learningjava;

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Quiz3QuestionBank {

    // declare list of Question objects
    List <Question1> list = new ArrayList<>();
    MyDataBaseHelper3 myDataBaseHelper;

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
        myDataBaseHelper = new MyDataBaseHelper3(context);
        list = myDataBaseHelper.getAllQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestion(new Question1("1. In Java, an array starts counting from...",
                    new String[]{"-1", "0", "1", "2"}, "0"));
            myDataBaseHelper.addInitialQuestion(new Question1("2. What is the output of this code?\nint tmp[ ] = {5, 8, 9, 3};\nSystem.out.println(tmp[2]);",
                    new String[]{"5", "8", "9", "3"}, "9"));
            myDataBaseHelper.addInitialQuestion(new Question1("3. What is the output of this code?\nString array[ ][ ] =  { {\"Hey\", \"John\", \"Bye\"},\\n{\"John\", \"Johnson\", \"Hello\"}};\nSystem.out.println(array[1][1]);",
                    new String[]{"Hello", "John", "Hey", "Johnson"}, "Johnson"));
            myDataBaseHelper.addInitialQuestion(new Question1("4. What is the output of this code?\nint arr[ ] = new int[3];\nfor (int i = 0; i < 3; i++) {\\n   arr[i] = i;}\n int res = arr[0] + arr[2];\nSystem.out.println(res);",
                    new String[]{"2", "4", "6", "8"}, "2"));
            myDataBaseHelper.addInitialQuestion(new Question1("5. What is the output of this code?\nint array[ ][ ] =  {{3, 5, 8}, {7, 54, 1, 12, 4}}; \nSystem.out.println(array[0][2]);",
                    new String[]{"1", "8", "5", "54"}, "8"));

            list = myDataBaseHelper.getAllQuestionsList();//get list from database again

        }
    }

}