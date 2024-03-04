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

public class ThirdActivity extends AppCompatActivity {
    Button back_to_breakfast, language_main, timer_btn_3_1;
    TextView text_3_1;
    private CountDownTimer timer6;
    private Vibrator vibrator_1;
    MediaPlayer player_1;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        back_to_breakfast = findViewById(R.id.back_to_breakfast);
        language_main = findViewById(R.id.language_main);
        timer_btn_3_1 = findViewById(R.id.timer_btn_3_1);
        text_3_1 = findViewById(R.id.text_3_1);

        vibrator_1=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        player_1=MediaPlayer.create(this,R.raw.finish);

        timer_btn_3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer6 != null){
                    timer6.cancel();
                    timer_btn_3_1.setText(getString(R.string.Frying_pancakes));
                    timer_btn_3_1.setBackgroundColor(Color.parseColor("#6750a4"));
                    timer6 = null;
                    text_3_1.setText("03:00");
                } else {
                    timer_btn_3_1.setText(getString(R.string.Cancel));
                    timer_btn_3_1.setBackgroundColor(Color.RED);
                    timer6=new CountDownTimer(3000,1000) {
                        @Override
                        public void onTick(long l) {
                            NumberFormat f = new DecimalFormat("00");
                            long sec = l/1000;
                            long min = sec/60;
//                        sec -= min*60;
                            sec = sec%60;
                            String time = f.format(min) + ":" + f.format(sec);
                            text_3_1.setText(time);
                        }

                        @Override
                        public void onFinish() {
                            player_1.start();
                            vibrator_1.vibrate(VibrationEffect.createOneShot(5000, 250));
                            timer_btn_3_1.setText(getString(R.string.Frying_pancakes));
                            timer_btn_3_1.setBackgroundColor(Color.parseColor("#6750a4"));
                            Toast.makeText(getApplicationContext(), getString(R.string.Ready), Toast.LENGTH_SHORT).show();
                            timer6 = null;
                            text_3_1.setText("03:00");
                        }
                    };
                    timer6.start();
                }
            }
        });

        back_to_breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this, BreakfastActivity.class);
                startActivity(intent);
            }
        });

        language_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this, LanguageMainActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            recreate();
            Intent intent = new Intent(ThirdActivity.this, ThirdActivity.class);
            startActivity(intent);
            finish();
        }
    }
}