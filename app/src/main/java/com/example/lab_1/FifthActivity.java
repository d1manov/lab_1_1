package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class FifthActivity extends AppCompatActivity {
    Button back_to_lunch, language_main, timer_btn_5_1, timer_btn_5_2, timer_btn_5_3, timer_btn_5_4, timer_btn_5_5;
    TextView text_5_1, text_5_2, text_5_3, text_5_4, text_5_5;
    private CountDownTimer timer9, timer10, timer11, timer12, timer13;
    private Vibrator vibrator_1, vibrator_2, vibrator_3, vibrator_4, vibrator_5;
    MediaPlayer player_1, player_2, player_3, player_4, player_5;
    private static final int REQUEST_CODE = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        back_to_lunch = findViewById(R.id.back_to_lunch);
        language_main = findViewById(R.id.language_main);
        timer_btn_5_1 = findViewById(R.id.timer_btn_5_1);
        timer_btn_5_2 = findViewById(R.id.timer_btn_5_2);
        timer_btn_5_3 = findViewById(R.id.timer_btn_5_3);
        timer_btn_5_4 = findViewById(R.id.timer_btn_5_4);
        timer_btn_5_5 = findViewById(R.id.timer_btn_5_5);
        text_5_1 = findViewById(R.id.text_5_1);
        text_5_2 = findViewById(R.id.text_5_2);
        text_5_3 = findViewById(R.id.text_5_3);
        text_5_4 = findViewById(R.id.text_5_4);
        text_5_5 = findViewById(R.id.text_5_5);

        vibrator_1=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        vibrator_2=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        vibrator_3=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        vibrator_4=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        vibrator_5=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        player_1=MediaPlayer.create(this,R.raw.finish);
        player_2=MediaPlayer.create(this,R.raw.finish);
        player_3=MediaPlayer.create(this,R.raw.finish);
        player_4=MediaPlayer.create(this,R.raw.finish);
        player_5=MediaPlayer.create(this,R.raw.finish);

        timer_btn_5_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer9 != null){
                    timer9.cancel();
                    timer_btn_5_1.setText(getString(R.string.Fry_the_fillet_until_golden_brown));
                    timer_btn_5_1.setBackgroundColor(Color.parseColor("#6750a4"));
                    timer9 = null;
                    text_5_1.setText("10:00");
                } else {
                    timer_btn_5_1.setText(getString(R.string.Cancel));
                    timer_btn_5_1.setBackgroundColor(Color.RED);
                    timer9=new CountDownTimer(3000,1000) {
                        @Override
                        public void onTick(long l) {
                            NumberFormat f = new DecimalFormat("00");
                            long sec = l/1000;
                            long min = sec/60;
//                        sec -= min*60;
                            sec = sec%60;
                            String time = f.format(min) + ":" + f.format(sec);
                            text_5_1.setText(time);
                        }

                        @Override
                        public void onFinish() {
                            player_1.start();
                            vibrator_1.vibrate(VibrationEffect.createOneShot(5000, 250));
                            timer_btn_5_1.setText(getString(R.string.Fry_the_fillet_until_golden_brown));
                            timer_btn_5_1.setBackgroundColor(Color.parseColor("#6750a4"));
                            Toast.makeText(getApplicationContext(), getString(R.string.Ready), Toast.LENGTH_SHORT).show();
                            timer9 = null;
                            text_5_1.setText("10:00");
                        }
                    };
                    timer9.start();
                }
            }
        });

        timer_btn_5_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer10 != null){
                    timer10.cancel();
                    timer_btn_5_2.setText(getString(R.string.Add_vegetables_and_fry_further));
                    timer_btn_5_2.setBackgroundColor(Color.parseColor("#6750a4"));
                    timer10 = null;
                    text_5_2.setText("05:00");
                } else {
                    timer_btn_5_2.setText(getString(R.string.Cancel));
                    timer_btn_5_2.setBackgroundColor(Color.RED);
                    timer10=new CountDownTimer(6000,1000) {
                        @Override
                        public void onTick(long l) {
                            NumberFormat f = new DecimalFormat("00");
                            long sec = l/1000;
                            long min = sec/60;
//                        sec -= min*60;
                            sec = sec%60;
                            String time = f.format(min) + ":" + f.format(sec);
                            text_5_2.setText(time);
                        }

                        @Override
                        public void onFinish() {
                            player_2.start();
                            vibrator_2.vibrate(VibrationEffect.createOneShot(5000, 250));
                            timer_btn_5_2.setText(getString(R.string.Add_vegetables_and_fry_further));
                            timer_btn_5_2.setBackgroundColor(Color.parseColor("#6750a4"));
                            Toast.makeText(getApplicationContext(), getString(R.string.Ready), Toast.LENGTH_SHORT).show();
                            timer10 = null;
                            text_5_2.setText("05:00");
                        }
                    };
                    timer10.start();
                }
            }
        });

        timer_btn_5_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer11 != null){
                    timer11.cancel();
                    timer_btn_5_3.setText(getString(R.string.Stir_and_simmer));
                    timer_btn_5_3.setBackgroundColor(Color.parseColor("#6750a4"));
                    timer11 = null;
                    text_5_3.setText("15:00");
                } else {
                    timer_btn_5_3.setText(getString(R.string.Cancel));
                    timer_btn_5_3.setBackgroundColor(Color.RED);
                    timer11=new CountDownTimer(9000,1000) {
                        @Override
                        public void onTick(long l) {
                            NumberFormat f = new DecimalFormat("00");
                            long sec = l/1000;
                            long min = sec/60;
//                        sec -= min*60;
                            sec = sec%60;
                            String time = f.format(min) + ":" + f.format(sec);
                            text_5_3.setText(time);
                        }

                        @Override
                        public void onFinish() {
                            player_3.start();
                            vibrator_3.vibrate(VibrationEffect.createOneShot(5000, 250));
                            timer_btn_5_3.setText(getString(R.string.Stir_and_simmer));
                            timer_btn_5_3.setBackgroundColor(Color.parseColor("#6750a4"));
                            Toast.makeText(getApplicationContext(), getString(R.string.Ready), Toast.LENGTH_SHORT).show();
                            timer11 = null;
                            text_5_3.setText("15:00");
                        }
                    };
                    timer11.start();
                }
            }
        });

        timer_btn_5_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer12 != null){
                    timer12.cancel();
                    timer_btn_5_4.setText(getString(R.string.Cooking_noodles));
                    timer_btn_5_4.setBackgroundColor(Color.parseColor("#6750a4"));
                    timer12 = null;
                    text_5_4.setText("10:00");
                } else {
                    timer_btn_5_4.setText(getString(R.string.Cancel));
                    timer_btn_5_4.setBackgroundColor(Color.RED);
                    timer12=new CountDownTimer(9000,1000) {
                        @Override
                        public void onTick(long l) {
                            NumberFormat f = new DecimalFormat("00");
                            long sec = l/1000;
                            long min = sec/60;
//                        sec -= min*60;
                            sec = sec%60;
                            String time = f.format(min) + ":" + f.format(sec);
                            text_5_4.setText(time);
                        }

                        @Override
                        public void onFinish() {
                            player_4.start();
                            vibrator_4.vibrate(VibrationEffect.createOneShot(5000, 250));
                            timer_btn_5_4.setText(getString(R.string.Cooking_noodles));
                            timer_btn_5_4.setBackgroundColor(Color.parseColor("#6750a4"));
                            Toast.makeText(getApplicationContext(), getString(R.string.Ready), Toast.LENGTH_SHORT).show();
                            timer12 = null;
                            text_5_4.setText("10:00");
                        }
                    };
                    timer12.start();
                }
            }
        });

        timer_btn_5_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer13 != null){
                    timer13.cancel();
                    timer_btn_5_5.setText(getString(R.string.Lets_simmer_everything_together));
                    timer_btn_5_5.setBackgroundColor(Color.parseColor("#6750a4"));
                    timer13 = null;
                    text_5_5.setText("05:00");
                } else {
                    timer_btn_5_5.setText(getString(R.string.Cancel));
                    timer_btn_5_5.setBackgroundColor(Color.RED);
                    timer13=new CountDownTimer(6000,1000) {
                        @Override
                        public void onTick(long l) {
                            NumberFormat f = new DecimalFormat("00");
                            long sec = l/1000;
                            long min = sec/60;
//                        sec -= min*60;
                            sec = sec%60;
                            String time = f.format(min) + ":" + f.format(sec);
                            text_5_5.setText(time);
                        }

                        @Override
                        public void onFinish() {
                            player_5.start();
                            vibrator_5.vibrate(VibrationEffect.createOneShot(5000, 250));
                            timer_btn_5_5.setText(getString(R.string.Lets_simmer_everything_together));
                            timer_btn_5_5.setBackgroundColor(Color.parseColor("#6750a4"));
                            Toast.makeText(getApplicationContext(), getString(R.string.Ready), Toast.LENGTH_SHORT).show();
                            timer13 = null;
                            text_5_5.setText("05:00");
                        }
                    };
                    timer13.start();
                }
            }
        });

        back_to_lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FifthActivity.this, LunchActivity.class);
                startActivity(intent);
            }
        });

        language_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FifthActivity.this, LanguageMainActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            recreate();
            Intent intent = new Intent(FifthActivity.this, FifthActivity.class);
            startActivity(intent);
            finish();
        }
    }
}