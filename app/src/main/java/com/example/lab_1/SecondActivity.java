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

public class SecondActivity extends AppCompatActivity {
    Button back_to_breakfast, language_main, timer_btn_2_1, timer_btn_2_2, timer_btn_2_3;
    TextView text_2_1, text_2_2, text_2_3;
    private CountDownTimer timer3, timer4, timer5;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        back_to_breakfast = findViewById(R.id.back_to_breakfast);
        language_main = findViewById(R.id.language_main);
        timer_btn_2_1 = findViewById(R.id.timer_btn_2_1);
        timer_btn_2_2 = findViewById(R.id.timer_btn_2_2);
        timer_btn_2_3 = findViewById(R.id.timer_btn_2_3);
        text_2_1 = findViewById(R.id.text_2_1);
        text_2_2 = findViewById(R.id.text_2_2);
        text_2_3 = findViewById(R.id.text_2_3);

        timer_btn_2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer3 != null){
                    timer3.cancel();
                    timer_btn_2_1.setText(getString(R.string.Fry_garlic_and_pepper));
                    timer_btn_2_1.setBackgroundColor(Color.parseColor("#6750a4"));
                    timer3 = null;
                    text_2_1.setText("03:00");
                } else {
                    timer_btn_2_1.setText(getString(R.string.Cancel));
                    timer_btn_2_1.setBackgroundColor(Color.RED);
                    timer3=new CountDownTimer(180000,1000) {
                        @Override
                        public void onTick(long l) {
                            NumberFormat f = new DecimalFormat("00");
                            long sec = l/1000;
                            long min = sec/60;
//                        sec -= min*60;
                            sec = sec%60;
                            String time = f.format(min) + ":" + f.format(sec);
                            text_2_1.setText(time);
                        }

                        @Override
                        public void onFinish() {
                            timer_btn_2_1.setText(getString(R.string.Fry_garlic_and_pepper));
                            timer_btn_2_1.setBackgroundColor(Color.parseColor("#6750a4"));
                            Toast.makeText(getApplicationContext(), getString(R.string.Ready), Toast.LENGTH_SHORT).show();
                        }
                    };
                    timer3.start();
                }
            }
        });

        timer_btn_2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer4 != null){
                    timer4.cancel();
                    timer_btn_2_2.setText(getString(R.string.Lets_stew));
                    timer_btn_2_2.setBackgroundColor(Color.parseColor("#6750a4"));
                    timer4 = null;
                    text_2_2.setText("08:00");
                } else {
                    timer_btn_2_2.setText(getString(R.string.Cancel));
                    timer_btn_2_2.setBackgroundColor(Color.RED);
                    timer4=new CountDownTimer(480000,1000) {
                        @Override
                        public void onTick(long l) {
                            NumberFormat f = new DecimalFormat("00");
                            long sec = l/1000;
                            long min = sec/60;
//                        sec -= min*60;
                            sec = sec%60;
                            String time = f.format(min) + ":" + f.format(sec);
                            text_2_2.setText(time);
                        }

                        @Override
                        public void onFinish() {
                            timer_btn_2_2.setText(getString(R.string.Lets_stew));
                            timer_btn_2_2.setBackgroundColor(Color.parseColor("#6750a4"));
                            Toast.makeText(getApplicationContext(), getString(R.string.Ready), Toast.LENGTH_SHORT).show();
                        }
                    };
                    timer4.start();
                }
            }
        });

        timer_btn_2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer5 != null){
                    timer5.cancel();
                    timer_btn_2_3.setText(getString(R.string.Continue_frying_until_done));
                    timer_btn_2_3.setBackgroundColor(Color.parseColor("#6750a4"));
                    timer5 = null;
                    text_2_3.setText("03:00");
                } else {
                    timer_btn_2_3.setText(getString(R.string.Cancel));
                    timer_btn_2_3.setBackgroundColor(Color.RED);
                    timer5=new CountDownTimer(300000,1000) {
                        @Override
                        public void onTick(long l) {
                            NumberFormat f = new DecimalFormat("00");
                            long sec = l/1000;
                            long min = sec/60;
//                        sec -= min*60;
                            sec = sec%60;
                            String time = f.format(min) + ":" + f.format(sec);
                            text_2_3.setText(time);
                        }

                        @Override
                        public void onFinish() {
                            timer_btn_2_3.setText(getString(R.string.Continue_frying_until_done));
                            timer_btn_2_3.setBackgroundColor(Color.parseColor("#6750a4"));
                            Toast.makeText(getApplicationContext(), getString(R.string.Ready), Toast.LENGTH_SHORT).show();
                        }
                    };
                    timer5.start();
                }
            }
        });

        back_to_breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, BreakfastActivity.class);
                startActivity(intent);
            }
        });

        language_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, LanguageMainActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            recreate();
            Intent intent = new Intent(SecondActivity.this, SecondActivity.class);
            startActivity(intent);
            finish();
        }
    }
}