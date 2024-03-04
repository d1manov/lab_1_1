package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class NinthActivity extends AppCompatActivity {
    Button back_to_dinner, language_main, timer_btn_9_1, timer_btn_9_2, timer_btn_9_3;
    TextView text_9_1, text_9_2, text_9_3;
    private CountDownTimer timer17, timer18, timer19;
    private Vibrator vibrator_1, vibrator_2, vibrator_3;
    MediaPlayer player_1, player_2, player_3;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninth);

        back_to_dinner = findViewById(R.id.back_to_dinner);
        language_main = findViewById(R.id.language_main);
        timer_btn_9_1 = findViewById(R.id.timer_btn_9_1);
        timer_btn_9_2 = findViewById(R.id.timer_btn_9_2);
        timer_btn_9_3 = findViewById(R.id.timer_btn_9_3);
        text_9_1 = findViewById(R.id.text_9_1);
        text_9_2 = findViewById(R.id.text_9_2);
        text_9_3 = findViewById(R.id.text_9_3);

        vibrator_1=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        vibrator_2=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        vibrator_3=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        player_1=MediaPlayer.create(this,R.raw.finish);
        player_2=MediaPlayer.create(this,R.raw.finish);
        player_3=MediaPlayer.create(this,R.raw.finish);

        timer_btn_9_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer17 != null){
                    timer17.cancel();
                    timer_btn_9_1.setText(getString(R.string.Cooking_potatoes));
                    timer_btn_9_1.setBackgroundColor(Color.parseColor("#6750a4"));
                    timer17 = null;
                    text_9_1.setText("20:00");
                } else {
                    timer_btn_9_1.setText(getString(R.string.Cancel));
                    timer_btn_9_1.setBackgroundColor(Color.RED);
                    timer17=new CountDownTimer(1200000,1000) {
                        @Override
                        public void onTick(long l) {
                            NumberFormat f = new DecimalFormat("00");
                            long sec = l/1000;
                            long min = sec/60;
//                        sec -= min*60;
                            sec = sec%60;
                            String time = f.format(min) + ":" + f.format(sec);
                            text_9_1.setText(time);
                        }

                        @Override
                        public void onFinish() {
                            player_1.start();
                            vibrator_1.vibrate(VibrationEffect.createOneShot(5000, 250));
                            timer_btn_9_1.setText(getString(R.string.Cooking_potatoes));
                            timer_btn_9_1.setBackgroundColor(Color.parseColor("#6750a4"));
                            Toast.makeText(getApplicationContext(), getString(R.string.Ready), Toast.LENGTH_SHORT).show();
                            timer17 = null;
                            text_9_1.setText("20:00");
                        }
                    };
                    timer17.start();
                }
            }
        });

        timer_btn_9_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer18 != null){
                    timer18.cancel();
                    timer_btn_9_2.setText(getString(R.string.Stew_vegetables_with_potatoes));
                    timer_btn_9_2.setBackgroundColor(Color.parseColor("#6750a4"));
                    timer18 = null;
                    text_9_2.setText("05:00");
                } else {
                    timer_btn_9_2.setText(getString(R.string.Cancel));
                    timer_btn_9_2.setBackgroundColor(Color.RED);
                    timer18=new CountDownTimer(300000,1000) {
                        @Override
                        public void onTick(long l) {
                            NumberFormat f = new DecimalFormat("00");
                            long sec = l/1000;
                            long min = sec/60;
//                        sec -= min*60;
                            sec = sec%60;
                            String time = f.format(min) + ":" + f.format(sec);
                            text_9_2.setText(time);
                        }

                        @Override
                        public void onFinish() {
                            player_2.start();
                            vibrator_2.vibrate(VibrationEffect.createOneShot(5000, 250));
                            timer_btn_9_2.setText(getString(R.string.Stew_vegetables_with_potatoes));
                            timer_btn_9_2.setBackgroundColor(Color.parseColor("#6750a4"));
                            Toast.makeText(getApplicationContext(), getString(R.string.Ready), Toast.LENGTH_SHORT).show();
                            timer18 = null;
                            text_9_2.setText("05:00");
                        }
                    };
                    timer18.start();
                }
            }
        });

        timer_btn_9_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer19 != null){
                    timer19.cancel();
                    timer_btn_9_3.setText(getString(R.string.Oven_timer));
                    timer_btn_9_3.setBackgroundColor(Color.parseColor("#6750a4"));
                    timer19 = null;
                    text_9_3.setText("15:00");
                } else {
                    timer_btn_9_3.setText(getString(R.string.Cancel));
                    timer_btn_9_3.setBackgroundColor(Color.RED);
                    timer19=new CountDownTimer(900000,1000) {
                        @Override
                        public void onTick(long l) {
                            NumberFormat f = new DecimalFormat("00");
                            long sec = l/1000;
                            long min = sec/60;
//                        sec -= min*60;
                            sec = sec%60;
                            String time = f.format(min) + ":" + f.format(sec);
                            text_9_3.setText(time);
                        }

                        @Override
                        public void onFinish() {
                            player_3.start();
                            vibrator_3.vibrate(VibrationEffect.createOneShot(5000, 250));
                            timer_btn_9_3.setText(getString(R.string.Oven_timer));
                            timer_btn_9_3.setBackgroundColor(Color.parseColor("#6750a4"));
                            Toast.makeText(getApplicationContext(), getString(R.string.Ready), Toast.LENGTH_SHORT).show();
                            timer19 = null;
                            text_9_3.setText("15:00");
                        }
                    };
                    timer19.start();
                }
            }
        });

        back_to_dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NinthActivity.this, DinnerActivity.class);
                startActivity(intent);
            }
        });

        language_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NinthActivity.this, LanguageMainActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            recreate();
            Intent intent = new Intent(NinthActivity.this, NinthActivity.class);
            startActivity(intent);
            finish();
        }
    }
}