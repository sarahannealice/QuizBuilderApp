package com.example.quizbuilderapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.*;

//java specific imports
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.util.HashMap;

public class Questions extends AppCompatActivity {
    //views
    static Button opt1Btn, opt2Btn, opt3Btn, opt4Btn;
    Button nextBtn;
    static TextView questionTv, progressTv;

    //variables
    static int result;
    static int counter;
    static String question;
    final String TAG = "Error";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        //initializing buttons
        opt1Btn = findViewById(R.id.opt1Btn);
        opt2Btn = findViewById(R.id.opt2Btn);
        opt3Btn = findViewById(R.id.opt3Btn);
        opt4Btn = findViewById(R.id.opt4Btn);
        nextBtn = findViewById(R.id.nextBtn);

        //initializing textviews
        questionTv = findViewById(R.id.questionTv);
        progressTv = findViewById(R.id.progressTv);

        //set answer button event to same listener
        opt1Btn.setOnClickListener(optBtnClicked);
        opt2Btn.setOnClickListener(optBtnClicked);
        opt3Btn.setOnClickListener(optBtnClicked);
        opt4Btn.setOnClickListener(optBtnClicked);

        //set next button event
        nextBtn.setOnClickListener(nextBtnClicked);

        //set initial screen setup
        QuizOperations.generateLists();
        question = QuizOperations.generateQuestion();
        QuizOperations.generateAnswers(question);

        counter = 1;
        String progress = counter + " / 10";
        progressTv.setText(progress);
    }//end onCreate

    //onClick for answers
    public View.OnClickListener optBtnClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int scoreAdd;
            switch (view.getId()) {
                case R.id.opt1Btn:
                    scoreAdd = QuizOperations.checkAnswer((String)questionTv.getText(), (String)opt1Btn.getText());
                    result += scoreAdd;
                    System.out.println("result: " + result);
                    break;
                case R.id.opt2Btn:
                    scoreAdd = QuizOperations.checkAnswer((String)questionTv.getText(), (String)opt1Btn.getText());
                    result += scoreAdd;
                    System.out.println("result: " + result);
                    break;
                case R.id.opt3Btn:
                    scoreAdd = QuizOperations.checkAnswer((String)questionTv.getText(), (String)opt1Btn.getText());
                    result += scoreAdd;
                    System.out.println("result: " + result);
                    break;
                case R.id.opt4Btn:
                    scoreAdd = QuizOperations.checkAnswer((String)questionTv.getText(), (String)opt1Btn.getText());
                    result += scoreAdd;
                    System.out.println("result: " + result);
                    break;
            }
        }
    };//end onClick for answers

    //onClick for next
    public View.OnClickListener nextBtnClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {//if statement to check if file is empty
            if (counter == 10) {
                Intent resultsIntent = new Intent(Questions.this, Results.class);
                startActivity(resultsIntent);
                System.out.println("your score is: " + result);
            } else {
                //randomize questions/answers
                question = QuizOperations.generateQuestion();
                QuizOperations.generateAnswers(question);
                counter++;
                QuizOperations.setProgress(counter);

                System.out.println("your score is: " + result);
            }
        }
    };//end onClick for next

}//end question class
