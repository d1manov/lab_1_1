package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import com.example.lab_1.MainActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

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

        english_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LanguageHelper.setLanguage(LanguageMainActivity.this, "en");
                setResult(RESULT_OK);
                onBackPressed();
            }
        });

        japanese_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LanguageHelper.setLanguage(LanguageMainActivity.this, "ja");
                setResult(RESULT_OK);
                onBackPressed();
            }
        });

        russian_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LanguageHelper.setLanguage(LanguageMainActivity.this, "ru");
                setResult(RESULT_OK);
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}