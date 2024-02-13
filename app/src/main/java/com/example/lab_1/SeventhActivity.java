package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SeventhActivity extends AppCompatActivity {
    Button back_to_dinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh);

        back_to_dinner = findViewById(R.id.back_to_dinner);

        back_to_dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeventhActivity.this, DinnerActivity.class);
                startActivity(intent);
            }
        });
    }
}