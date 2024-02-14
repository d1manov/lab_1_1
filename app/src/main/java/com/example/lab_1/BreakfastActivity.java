package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BreakfastActivity extends AppCompatActivity {
    Button back_to_main, first_btn, second_btn, third_btn, language_main;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);

        back_to_main = findViewById(R.id.back_to_main);
        first_btn = findViewById(R.id.first_btn);
        second_btn = findViewById(R.id.second_btn);
        third_btn = findViewById(R.id.third_btn);
        language_main = findViewById(R.id.language_main);

        back_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BreakfastActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        first_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BreakfastActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

        second_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BreakfastActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        third_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BreakfastActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

        language_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BreakfastActivity.this, LanguageMainActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            recreate();
            Intent intent = new Intent(BreakfastActivity.this, BreakfastActivity.class);
            startActivity(intent);
            finish();
        }
    }
}