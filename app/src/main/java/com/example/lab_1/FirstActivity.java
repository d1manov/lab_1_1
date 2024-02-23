package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FirstActivity extends AppCompatActivity {
    Button back_to_breakfast, language_main, timer_btn_1_1, timer_btn_1_2;
    TextView text_1_1, text_1_2;
    private CountDownTimer timer1, timer2;
    private static final int REQUEST_CODE = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        back_to_breakfast = findViewById(R.id.back_to_breakfast);
        language_main = findViewById(R.id.language_main);
        timer_btn_1_1 = findViewById(R.id.timer_btn_1_1);
        timer_btn_1_2 = findViewById(R.id.timer_btn_1_2);
        text_1_1 = findViewById(R.id.text_1_1);
        text_1_2 = findViewById(R.id.text_1_2);

        timer_btn_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer1 != null){
                    timer1.cancel();
                    timer_btn_1_1.setText(getString(R.string.Cooking_porridge));
                    timer_btn_1_1.setBackgroundColor(Color.parseColor("#6750a4"));
                    timer1 = null;
                    text_1_1.setText("03:00");
                } else {
                    timer_btn_1_1.setText(getString(R.string.Cancel));
                    timer_btn_1_1.setBackgroundColor(Color.RED);
                    timer1=new CountDownTimer(180000,1000) {
                        @Override
                        public void onTick(long l) {
                            NumberFormat f = new DecimalFormat("00");
                            long sec = l/1000;
                            long min = sec/60;
//                        sec -= min*60;
                            sec = sec%60;
                            String time = f.format(min) + ":" + f.format(sec);
                            text_1_1.setText(time);
                        }

                        @Override
                        public void onFinish() {
                            timer_btn_1_1.setText(getString(R.string.Cooking_porridge));
                            timer_btn_1_1.setBackgroundColor(Color.parseColor("#6750a4"));
                            Toast.makeText(getApplicationContext(), getString(R.string.Ready), Toast.LENGTH_SHORT).show();
                        }
                    };
                    timer1.start();
                }
            }
        });

        timer_btn_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer2 != null){
                    timer2.cancel();
                    timer_btn_1_2.setText(getString(R.string.Fry_the_meatballs));
                    timer_btn_1_2.setBackgroundColor(Color.parseColor("#6750a4"));
                    timer2 = null;
                    text_1_2.setText("03:00");
                } else {
                    timer_btn_1_2.setText(getString(R.string.Cancel));
                    timer_btn_1_2.setBackgroundColor(Color.RED);
                    timer2=new CountDownTimer(180000,1000) {
                        @Override
                        public void onTick(long l) {
                            NumberFormat f = new DecimalFormat("00");
                            long sec = l/1000;
                            long min = sec/60;
//                        sec -= min*60;
                            sec = sec%60;
                            String time = f.format(min) + ":" + f.format(sec);
                            text_1_2.setText(time);
                        }

                        @Override
                        public void onFinish() {
                            timer_btn_1_2.setText(getString(R.string.Fry_the_meatballs));
                            timer_btn_1_2.setBackgroundColor(Color.parseColor("#6750a4"));
                            Toast.makeText(getApplicationContext(), getString(R.string.Ready), Toast.LENGTH_SHORT).show();
                        }
                    };
                    timer2.start();
                }
            }
        });

        back_to_breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, BreakfastActivity.class);
                startActivity(intent);
            }
        });

        language_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, LanguageMainActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            recreate();
            Intent intent = new Intent(FirstActivity.this, FirstActivity.class);
            startActivity(intent);
            finish();
        }
    }
}