package com.example.quizbuilderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Results extends AppCompatActivity {
    //views
    Button tryAgainBtn;
    static TextView resultsTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //initializing buttons/textviews
        tryAgainBtn = findViewById(R.id.tryAgainBtn);
        resultsTv = findViewById(R.id.resultsTv);

        tryAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivityIntent = new Intent(Results.this, MainActivity.class);
                startActivity(mainActivityIntent);
            }
        });
    }
}
