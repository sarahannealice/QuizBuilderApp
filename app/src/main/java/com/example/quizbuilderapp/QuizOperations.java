package com.example.quizbuilderapp;

import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;

public class QuizOperations {
    static ArrayList<String> questions = new ArrayList<>();
    static ArrayList<String> answers = new ArrayList<>();
    //hashmap variable
    static HashMap<String, String> qas = new HashMap<String, String>();

    public static void generateQuestion() {
        answers.add("red");
        answers.add("orange");
        answers.add("yellow");
        answers.add("pink");
        answers.add("blue");

        questions.add("mixed with blue creates purple");
        questions.add("the complementary colour to blue");
        questions.add("a primary colour with six letters");
        questions.add("the colour associated with love");
        questions.add("often misinterpreted as the colour of the sky");

        //adding arraylists to hashmap
        qas.put(questions.get(0), answers.get(0));
        qas.put(questions.get(1), answers.get(1));
        qas.put(questions.get(2), answers.get(2));
        qas.put(questions.get(3), answers.get(3));
        qas.put(questions.get(4), answers.get(4));

        Collections.shuffle(questions);
        System.out.println(questions);
//        Collections.shuffle(answers);

        //setting question and buttons text
        Questions.questionTv.setText(questions.get(0));
//        Questions.
    }

    public static void setProgress(int counter) {
        String progress = counter + " / 10";
        Questions.progressTv.setText(progress);
    }
}
