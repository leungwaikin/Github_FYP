package com.example.kin.learningjava;

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Quiz6QuestionBank {

    // declare list of Question objects
    List <Question1> list = new ArrayList<>();
    MyDataBaseHelper6 myDataBaseHelper;

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
        myDataBaseHelper = new MyDataBaseHelper6(context);
        list = myDataBaseHelper.getAllQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestion(new Question1("1. What is the output of the following code?\nint f=1, i=2;\nwhile(++i<5)\n   f*=i;\nSystem.out.println(f);",
                    new String[]{"4", "12", "20", "24"}, "12"));
            myDataBaseHelper.addInitialQuestion(new Question1("2. Which class is used to write content to files?",
                    new String[]{"Set", "ArrayList", "Scanner", "Formatter"}, "Formatter"));
            myDataBaseHelper.addInitialQuestion(new Question1("3. What is the output of this code?\nimport java.util.HashSet;\nclass A {\n   public static void main(String[ ] args) {\n   HashSet<String> set = new HashSet<String>();\n   set.add(\"A\");\n   set.add(\"B\");\n   set.add(\"C\");\n   System.out.println(set.size());}\n}",
                    new String[]{"1", "3", "4", "C"}, "3"));
            myDataBaseHelper.addInitialQuestion(new Question1("4. What is the output of this code?\nArrayList<String> list = new ArrayList<String>();\nlist.add(\"A\");\nlist.add(\"B\");\nlist.add(\"C\");\nSystem.out.println(list.get(1));",
                    new String[]{"A", "B", "C", "1"}, "B"));
            myDataBaseHelper.addInitialQuestion(new Question1("5. How many catch blocks can a try/catch block contain?",
                    new String[]{"Only two", "Only one", "As many as you need", "None"}, "As many as you need"));

            list = myDataBaseHelper.getAllQuestionsList();//get list from database again

        }
    }

}