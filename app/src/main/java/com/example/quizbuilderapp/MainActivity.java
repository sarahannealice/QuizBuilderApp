package com.example.quizbuilderapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

//java specific imports

public class MainActivity extends AppCompatActivity {
    //views
    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing buttons
        startBtn = findViewById(R.id.startBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent questIntent = new Intent("Question");
                startActivity(questIntent);
//                Bundle extras = new Bundle();
//                extras.putString("KEY", "Stuff from bundle");
//                questIntent.putExtras(extras);
//                startActivityForResult(questIntent, 1);
//                setContentView(R.layout.activity_questions);
            }
        });
    }
}