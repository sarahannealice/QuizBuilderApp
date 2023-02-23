package com.example.quizbuilderapp;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class QuizOperations {
    //arraylists
    static ArrayList<String> questions = new ArrayList<>();
    static ArrayList<String> answers = new ArrayList<>();
    //hashmap
    static HashMap<String, String> qas = new HashMap<String, String>();

    //methods to generate lists -- file io -- reference: Kaitlyn Archambault & https://stackoverflow.com/a/68484308
    public static void generateLists(Context context) {
        InputStream inputStream;
        BufferedReader read = null;

        try {
            inputStream = context.getResources().openRawResource(R.raw.quiz_questions);

            if (inputStream != null) {
                read = new BufferedReader(new InputStreamReader(inputStream));

                //while loop to check if there are more lines to read
                String fileLine;
                String[] qa;

                while ((fileLine = read.readLine()) != null) {
                    qa = fileLine.split("\\$\\$");

                    questions.add(qa[0]);
                    answers.add(qa[1]);
                }
            }
        } catch (IOException e)

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
        questions.add("due to it's rarity, has a shorter history than other colours");
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

    //method to generate random question
    public static String generateQuestion() {
        String question;
        Collections.shuffle(questions);

        //setting question text
        question = questions.get(0);
        Questions.questionTv.setText(question);
        questions.remove(0);
        return question;
    }

    //method to generate random, unique answers
    public static void generateAnswers(String question) {
        //reset buttons to blank
        Questions.opt1Btn.setText(qas.get(""));
        Questions.opt2Btn.setText(qas.get(""));
        Questions.opt3Btn.setText(qas.get(""));
        Questions.opt4Btn.setText(qas.get(""));

        //shuffle answers
        Collections.shuffle(answers);

        //setup for random generator
        int min = 1;
        int max = 4;
        int answerPosition = (int)Math.floor(Math.random() *(max - min + 1) + min);
        System.out.println(answerPosition);

        //randomly place correct answer
        switch (answerPosition) {
            case 1:
                Questions.opt1Btn.setText(qas.get(question));
                break;
            case 2:
                Questions.opt2Btn.setText(qas.get(question));
                break;
            case 3:
                Questions.opt3Btn.setText(qas.get(question));
                break;
            case 4:
                Questions.opt4Btn.setText(qas.get(question));
                break;
        }

        //fill in rest of buttons
        for (int i = 0; i < 5; i++) {
            if (!answers.get(i).equals(qas.get(question))) {
                if (Questions.opt1Btn.getText().equals("") && !Questions.opt1Btn.getText().equals(answers.get(i))) {
                    Questions.opt1Btn.setText(answers.get(i));
                } else if (Questions.opt2Btn.getText().equals("") && !Questions.opt2Btn.getText().equals(answers.get(i))) {
                    Questions.opt2Btn.setText(answers.get(i));
                } else if (Questions.opt3Btn.getText().equals("") && !Questions.opt2Btn.getText().equals(answers.get(i))) {
                    Questions.opt3Btn.setText(answers.get(i));
                } else if (Questions.opt4Btn.getText().equals("") && !Questions.opt2Btn.getText().equals(answers.get(i))) {
                    Questions.opt4Btn.setText(answers.get(i));
                }
            }
        }
    }//

    //method to check chosen answer
    public static int checkAnswer(String question, String chosenAnswer, int buttonClicked) {
        if (Objects.equals(qas.get(question), chosenAnswer)) {
            return 1;
        } else {
            return 0;
        }
    }

    //disable answer buttons
    public static void disableBtn() {
        Questions.opt1Btn.setEnabled(false);
        Questions.opt2Btn.setEnabled(false);
        Questions.opt3Btn.setEnabled(false);
        Questions.opt4Btn.setEnabled(false);
    }

    //re-enable answer buttons
    public static void enableBtn() {
        Questions.opt1Btn.setEnabled(true);
        Questions.opt2Btn.setEnabled(true);
        Questions.opt3Btn.setEnabled(true);
        Questions.opt4Btn.setEnabled(true);
    }

    //method for progress counter
    public static void setProgress(int counter) {
        String progress = counter + " / 10";
        Questions.progressTv.setText(progress);
    }
}