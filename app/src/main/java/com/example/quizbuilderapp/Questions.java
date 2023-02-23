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
    static int counter = 1;
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

        //set initial progress
        String progress = counter + " / 10";
        progressTv.setText(progress);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//if statement to check if file is empty
                if (counter == 10) {
                    Intent resultsIntent = new Intent(Questions.this, Results.class);
                    startActivity(resultsIntent);
                } else {
                    //randomize questions/answers
                    QuizOperations.generateQuestion();
                    counter++;
                    QuizOperations.setProgress(counter);
                }
            }
        });
    }//end onCreate

    //onClick for answers
    public View.OnClickListener optBtnClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.opt1Btn:
                    //check if correct
                    break;
                case R.id.opt2Btn:
                    //check if correct
                    break;
                case R.id.opt3Btn:
                    //check if correct
                    break;
                case R.id.opt4Btn:
                    //check if correct
                    break;
            }
        }
    };//end onClick for options

    //onClick for next
//    public View.OnClickListener nextBtnClicked = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            switch (view.getId()) {
//                case R.id.nextBtn:
//                    //if statement to check if file is empty
//                    if (counter > 10) {
//                        Intent resultsIntent = new Intent(Questions.this, Results.class);
//                        startActivity(resultsIntent);
//                    } else {
//                        //randomize questions/answers
////                QuizOperations.generateQuestion(counter);
//                        counter++;
//                        QuizOperations.setProgress(counter);
//                    }
//            }
//        }
//    };
}//end question class
