package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SIxthActivity extends AppCompatActivity {
    Button back_to_lunch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        back_to_lunch = findViewById(R.id.back_to_lunch);

        back_to_lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SIxthActivity.this, LunchActivity.class);
                startActivity(intent);
            }
        });
    }
}