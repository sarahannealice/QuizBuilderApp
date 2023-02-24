package com.example.quizbuilderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizResults extends AppCompatActivity {
    //views
    Button tryAgainBtn;
    static TextView resultsTv;

    //variables
    public static final String KEY = "KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //initializing buttons/textviews
        tryAgainBtn = findViewById(R.id.tryAgainBtn);
        resultsTv = findViewById(R.id.resultsTv);

        Intent resultsIntent = getIntent();
        String result = resultsIntent.getStringExtra(KEY);
        resultsTv.setText(result + " / 10");

        tryAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivityIntent = new Intent(QuizResults.this, QuizStart.class);
                startActivity(mainActivityIntent);
            }
        });//end onClick for try again
    }//end onCreate
}//end results class
