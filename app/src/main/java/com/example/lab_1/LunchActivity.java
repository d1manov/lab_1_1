package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LunchActivity extends AppCompatActivity {
    Button back_to_main, fourth_btn, fifth_btn, sixth_btn, language_main;
    private static final int REQUEST_CODE = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);

        back_to_main = findViewById(R.id.back_to_main);
        fourth_btn = findViewById(R.id.fourth_btn);
        fifth_btn = findViewById(R.id.fifth_btn);
        sixth_btn = findViewById(R.id.sixth_btn);
        language_main = findViewById(R.id.language_main);

        back_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LunchActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        fourth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LunchActivity.this, FourthActivity.class);
                startActivity(intent);
            }
        });

        fifth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LunchActivity.this, FifthActivity.class);
                startActivity(intent);
            }
        });

        sixth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LunchActivity.this, SIxthActivity.class);
                startActivity(intent);
            }
        });

        language_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LunchActivity.this, LanguageMainActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            recreate();
            Intent intent = new Intent(LunchActivity.this, LunchActivity.class);
            startActivity(intent);
            finish();
        }
    }
}