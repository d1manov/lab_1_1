package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FifthActivity extends AppCompatActivity {
    Button back_to_lunch;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        back_to_lunch = findViewById(R.id.back_to_lunch);

        back_to_lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FifthActivity.this, LunchActivity.class);
                startActivity(intent);
            }
        });
    }
}