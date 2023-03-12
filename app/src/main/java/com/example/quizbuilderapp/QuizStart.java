//created by: sarah newman
//mobi3002: assignment 2 -- quiz builder

package com.example.quizbuilderapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;


public class QuizStart extends AppCompatActivity {
    //views
    Button startBtn;

    //onCreate for start page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //initializing buttons
        startBtn = findViewById(R.id.startBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent questIntent = new Intent(QuizStart.this, QuizQuestions.class);
                startActivity(questIntent);
            }
        });//end onClick for start button
    }//end onCreate
}//end main activity class