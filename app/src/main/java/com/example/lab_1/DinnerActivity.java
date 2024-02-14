package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DinnerActivity extends AppCompatActivity {
    Button back_to_main, seventh_btn, eighth_btn, ninth_btn, language_main;
    private static final int REQUEST_CODE = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);

        back_to_main = findViewById(R.id.back_to_main);
        seventh_btn = findViewById(R.id.seventh_btn);
        eighth_btn = findViewById(R.id.eighth_btn);
        ninth_btn = findViewById(R.id.ninth_btn);
        language_main = findViewById(R.id.language_main);

        seventh_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DinnerActivity.this, SeventhActivity.class);
                startActivity(intent);
            }
        });

        eighth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DinnerActivity.this, EighthActivity.class);
                startActivity(intent);
            }
        });

        ninth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DinnerActivity.this, NinthActivity.class);
                startActivity(intent);
            }
        });

        back_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DinnerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        language_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DinnerActivity.this, LanguageMainActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            recreate();
            Intent intent = new Intent(DinnerActivity.this, DinnerActivity.class);
            startActivity(intent);
            finish();
        }
    }
}