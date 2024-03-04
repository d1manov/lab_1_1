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

public class SeventhActivity extends AppCompatActivity {
    Button back_to_dinner, language_main, timer_btn_7_1, timer_btn_7_2;
    TextView text_7_1, text_7_2;
    private CountDownTimer timer15, timer16;
    private Vibrator vibrator_1, vibrator_2;
    MediaPlayer player_1, player_2;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh);

        back_to_dinner = findViewById(R.id.back_to_dinner);
        language_main = findViewById(R.id.language_main);
        timer_btn_7_1 = findViewById(R.id.timer_btn_7_1);
        text_7_1 = findViewById(R.id.text_7_1);
        timer_btn_7_2 = findViewById(R.id.timer_btn_7_2);
        text_7_2 = findViewById(R.id.text_7_2);

        vibrator_1=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        vibrator_2=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        player_1=MediaPlayer.create(this,R.raw.finish);
        player_2=MediaPlayer.create(this,R.raw.finish);

        timer_btn_7_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer15 != null){
                    timer15.cancel();
                    timer_btn_7_1.setText(getString(R.string.Fry_fillet_with_onions));
                    timer_btn_7_1.setBackgroundColor(Color.parseColor("#6750a4"));
                    timer15 = null;
                    text_7_1.setText("04:00");
                } else {
                    timer_btn_7_1.setText(getString(R.string.Cancel));
                    timer_btn_7_1.setBackgroundColor(Color.RED);
                    timer15=new CountDownTimer(240000,1000) {
                        @Override
                        public void onTick(long l) {
                            NumberFormat f = new DecimalFormat("00");
                            long sec = l/1000;
                            long min = sec/60;
//                        sec -= min*60;
                            sec = sec%60;
                            String time = f.format(min) + ":" + f.format(sec);
                            text_7_1.setText(time);
                        }

                        @Override
                        public void onFinish() {
                            player_1.start();
                            vibrator_1.vibrate(VibrationEffect.createOneShot(5000, 250));
                            timer_btn_7_1.setText(getString(R.string.Fry_fillet_with_onions));
                            timer_btn_7_1.setBackgroundColor(Color.parseColor("#6750a4"));
                            Toast.makeText(getApplicationContext(), getString(R.string.Ready), Toast.LENGTH_SHORT).show();
                            timer15 = null;
                            text_7_1.setText("04:00");
                        }
                    };
                    timer15.start();
                }
            }
        });

        timer_btn_7_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer16 != null){
                    timer16.cancel();
                    timer_btn_7_2.setText(getString(R.string.Fry_after_adding_mushrooms));
                    timer_btn_7_2.setBackgroundColor(Color.parseColor("#6750a4"));
                    timer16 = null;
                    text_7_2.setText("07:00");
                } else {
                    timer_btn_7_2.setText(getString(R.string.Cancel));
                    timer_btn_7_2.setBackgroundColor(Color.RED);
                    timer16=new CountDownTimer(420000,1000) {
                        @Override
                        public void onTick(long l) {
                            NumberFormat f = new DecimalFormat("00");
                            long sec = l/1000;
                            long min = sec/60;
//                        sec -= min*60;
                            sec = sec%60;
                            String time = f.format(min) + ":" + f.format(sec);
                            text_7_2.setText(time);
                        }

                        @Override
                        public void onFinish() {
                            player_2.start();
                            vibrator_2.vibrate(VibrationEffect.createOneShot(5000, 250));
                            timer_btn_7_2.setText(getString(R.string.Fry_after_adding_mushrooms));
                            timer_btn_7_2.setBackgroundColor(Color.parseColor("#6750a4"));
                            Toast.makeText(getApplicationContext(), getString(R.string.Ready), Toast.LENGTH_SHORT).show();
                            timer16 = null;
                            text_7_2.setText("07:00");
                        }
                    };
                    timer16.start();
                }
            }
        });

        back_to_dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeventhActivity.this, DinnerActivity.class);
                startActivity(intent);
            }
        });

        language_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeventhActivity.this, LanguageMainActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            recreate();
            Intent intent = new Intent(SeventhActivity.this, SeventhActivity.class);
            startActivity(intent);
            finish();
        }
    }
}