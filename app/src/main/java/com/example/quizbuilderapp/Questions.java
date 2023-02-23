package com.example.quizbuilderapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class Questions extends AppCompatActivity {
    //views
    static Button opt1Btn, opt2Btn, opt3Btn, opt4Btn;
    Button nextBtn;
    static TextView questionTv, progressTv;

    //variables
    static int result = 0;
    static int counter;
    static String question;
    public static final String KEY = "KEY";

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
            int scoreAdd = 0;

            switch (view.getId()) {
                case R.id.opt1Btn:
                    scoreAdd = QuizOperations.checkAnswer((String) questionTv.getText(), (String) opt1Btn.getText(), 1);
                    if (scoreAdd == 1) {
                        opt1Btn.setBackgroundColor(getResources().getColor(R.color.correct, getTheme()));
                    } else {
                        opt1Btn.setBackgroundColor(getResources().getColor(R.color.incorrect, getTheme()));
                    }
                    //disabling other buttons
                    QuizOperations.disableBtn();
                    result += scoreAdd;
                    break;
                case R.id.opt2Btn:
                    scoreAdd = QuizOperations.checkAnswer((String) questionTv.getText(), (String) opt2Btn.getText(), 2);
                    if (scoreAdd == 1) {
                        opt2Btn.setBackgroundColor(getResources().getColor(R.color.correct, getTheme()));
                    } else {
                        opt2Btn.setBackgroundColor(getResources().getColor(R.color.incorrect, getTheme()));
                    }
                    //disabling other buttons
                    QuizOperations.disableBtn();
                    result += scoreAdd;
                    break;
                case R.id.opt3Btn:
                    scoreAdd = QuizOperations.checkAnswer((String) questionTv.getText(), (String) opt3Btn.getText(), 3);
                    if (scoreAdd == 1) {
                        opt3Btn.setBackgroundColor(getResources().getColor(R.color.correct, getTheme()));
                    } else {
                        opt3Btn.setBackgroundColor(getResources().getColor(R.color.incorrect, getTheme()));
                    }
                    //disabling other buttons
                    QuizOperations.disableBtn();
                    result += scoreAdd;
                    break;
                case R.id.opt4Btn:
                    scoreAdd = QuizOperations.checkAnswer((String) questionTv.getText(), (String) opt4Btn.getText(), 4);
                    if (scoreAdd == 1) {
                        opt4Btn.setBackgroundColor(getResources().getColor(R.color.correct, getTheme()));
                    } else {
                        opt4Btn.setBackgroundColor(getResources().getColor(R.color.incorrect, getTheme()));
                    }
                    //disabling other buttons
                    QuizOperations.disableBtn();
                    result += scoreAdd;
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
                resultsIntent.putExtra(KEY, Integer.toString(result));
                startActivity(resultsIntent);
                System.out.println("your score is: " + result);
            } else {
                //re-enabling answer buttons
                QuizOperations.enableBtn();

                //reset answer button colours
                opt1Btn.setBackgroundColor(getResources().getColor(R.color.option1, getTheme()));
                opt2Btn.setBackgroundColor(getResources().getColor(R.color.option2, getTheme()));
                opt3Btn.setBackgroundColor(getResources().getColor(R.color.option3, getTheme()));
                opt4Btn.setBackgroundColor(getResources().getColor(R.color.option4, getTheme()));

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
