package com.example.quizbuilderapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

//java specific imports
import java.util.ArrayList;

public class Questions extends AppCompatActivity {
    //views
    Button opt1Btn, opt2Btn, opt3Btn, opt4Btn;
    Button nextBtn;
    static TextView questionTv, progressTv;

    //variables
    static int counter = 0;
    static ArrayList<String> definitions = new ArrayList<>();
    static ArrayList<String> terms = new ArrayList<>();
    //hashmap variable

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

        //if statement to check if file is empty
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultsIntent = new Intent(Questions.this, Results.class);
                startActivity(resultsIntent);
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
    };

    //onClick for next
//    public View.OnClickListener nextBtnClicked = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            //if statement to check whether to go to results or not
////            if (counter == 10) {
////                Intent resultsIntent = new Intent(getBaseContext(), Results.class);
////                startActivity(resultsIntent);
//            //} else {
//                setContentView(R.layout.activity_results);
//            //}
//        }
//    };
}//end question class
