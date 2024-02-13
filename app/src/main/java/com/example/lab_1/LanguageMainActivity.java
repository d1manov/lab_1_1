package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LanguageMainActivity extends AppCompatActivity {
    Button back_to, russian_btn, english_btn, japanese_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_main);

        back_to = findViewById(R.id.back_to);
        russian_btn = findViewById(R.id.russian_btn);
        english_btn = findViewById(R.id.english_btn);
        japanese_btn = findViewById(R.id.japanese_btn);

        back_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}