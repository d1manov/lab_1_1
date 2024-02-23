package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

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

public class FourthActivity extends AppCompatActivity {
    Button back_to_lunch, language_main, timer_btn_4_1, timer_btn_4_2;
    TextView text_4_1, text_4_2;
    private CountDownTimer timer7, timer8;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        back_to_lunch = findViewById(R.id.back_to_lunch);
        language_main = findViewById(R.id.language_main);
        timer_btn_4_1 = findViewById(R.id.timer_btn_4_1);
        timer_btn_4_2 = findViewById(R.id.timer_btn_4_2);
        text_4_1 = findViewById(R.id.text_4_1);
        text_4_2 = findViewById(R.id.text_4_2);

        timer_btn_4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer7 != null){
                    timer7.cancel();
                    timer_btn_4_1.setText(getString(R.string.Fry_the_onion));
                    timer_btn_4_1.setBackgroundColor(Color.parseColor("#6750a4"));
                    timer7 = null;
                    text_4_1.setText("06:00");
                } else {
                    timer_btn_4_1.setText(getString(R.string.Cancel));
                    timer_btn_4_1.setBackgroundColor(Color.RED);
                    timer7=new CountDownTimer(360000,1000) {
                        @Override
                        public void onTick(long l) {
                            NumberFormat f = new DecimalFormat("00");
                            long sec = l/1000;
                            long min = sec/60;
//                        sec -= min*60;
                            sec = sec%60;
                            String time = f.format(min) + ":" + f.format(sec);
                            text_4_1.setText(time);
                        }

                        @Override
                        public void onFinish() {
                            timer_btn_4_1.setText(getString(R.string.Fry_the_onion));
                            timer_btn_4_1.setBackgroundColor(Color.parseColor("#6750a4"));
                            Toast.makeText(getApplicationContext(), getString(R.string.Ready), Toast.LENGTH_SHORT).show();
                        }
                    };
                    timer7.start();
                }
            }
        });

        timer_btn_4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer8 != null){
                    timer8.cancel();
                    timer_btn_4_2.setText(getString(R.string.Oven_timer));
                    timer_btn_4_2.setBackgroundColor(Color.parseColor("#6750a4"));
                    timer8 = null;
                    text_4_2.setText("23:00");
                } else {
                    timer_btn_4_2.setText(getString(R.string.Cancel));
                    timer_btn_4_2.setBackgroundColor(Color.RED);
                    timer8=new CountDownTimer(1380000,1000) {
                        @Override
                        public void onTick(long l) {
                            NumberFormat f = new DecimalFormat("00");
                            long sec = l/1000;
                            long min = sec/60;
//                        sec -= min*60;
                            sec = sec%60;
                            String time = f.format(min) + ":" + f.format(sec);
                            text_4_2.setText(time);
                        }

                        @Override
                        public void onFinish() {
                            timer_btn_4_2.setText(getString(R.string.Oven_timer));
                            timer_btn_4_2.setBackgroundColor(Color.parseColor("#6750a4"));
                            Toast.makeText(getApplicationContext(), getString(R.string.Ready), Toast.LENGTH_SHORT).show();
                        }
                    };
                    timer8.start();
                }
            }
        });

        back_to_lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FourthActivity.this, LunchActivity.class);
                startActivity(intent);
            }
        });

        language_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FourthActivity.this, LanguageMainActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            recreate();
            Intent intent = new Intent(FourthActivity.this, FourthActivity.class);
            startActivity(intent);
            finish();
        }
    }
}