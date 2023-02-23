package com.example.quizbuilderapp;

import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;

public class QuizOperations {
    static ArrayList<String> questions = new ArrayList<>();
    static ArrayList<String> answers = new ArrayList<>();
    //hashmap variable
    static HashMap<String, String> qas = new HashMap<String, String>();

    public static void generateLists() {
        //temporary hardcode answers
        answers.add("red");
        answers.add("orange");
        answers.add("yellow");
        answers.add("pink");
        answers.add("blue");
        answers.add("white");
        answers.add("black");
        answers.add("green");
        answers.add("purple");
        answers.add("complementary");

        //temporary hardcode questions
        questions.add("mixed with blue creates purple");
        questions.add("the complementary colour to blue");
        questions.add("a primary colour with six letters");
        questions.add("the colour associated with love");
        questions.add("often misinterpreted as the colour of the sky");
        questions.add("the absence of colour");
        questions.add("the combination of all colours");
        questions.add("the primary colour of this app");
        questions.add("a once-royal colour symbolizing nobility");
        questions.add("these two colours create grey");

        //adding arraylists to hashmap
        for (int i = 0; i < questions.size(); i++){
            qas.put(questions.get(i), answers.get(i));
        }
    }

    public static void generateQuestion() {

        Collections.shuffle(questions);
//        Collections.shuffle(answers);

        //setting question and buttons text
        Questions.questionTv.setText(questions.get(0));
        questions.remove(0);
//        Questions.
    }

    public static void setProgress(int counter) {
        String progress = counter + " / 10";
        Questions.progressTv.setText(progress);
    }
}
