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

public class SIxthActivity extends AppCompatActivity {
    Button back_to_lunch, language_main, timer_btn_6_1;
    TextView text_6_1;
    private CountDownTimer timer14;
    private Vibrator vibrator_1;
    MediaPlayer player_1;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        back_to_lunch = findViewById(R.id.back_to_lunch);
        language_main = findViewById(R.id.language_main);
        timer_btn_6_1 = findViewById(R.id.timer_btn_6_1);
        text_6_1 = findViewById(R.id.text_6_1);

        vibrator_1=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        player_1=MediaPlayer.create(this,R.raw.finish);

        timer_btn_6_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer14 != null){
                    timer14.cancel();
                    timer_btn_6_1.setText(getString(R.string.Frying_the_brisket));
                    timer_btn_6_1.setBackgroundColor(Color.parseColor("#6750a4"));
                    timer14 = null;
                    text_6_1.setText("10:00");
                } else {
                    timer_btn_6_1.setText(getString(R.string.Cancel));
                    timer_btn_6_1.setBackgroundColor(Color.RED);
                    timer14=new CountDownTimer(600000,1000) {
                        @Override
                        public void onTick(long l) {
                            NumberFormat f = new DecimalFormat("00");
                            long sec = l/1000;
                            long min = sec/60;
//                        sec -= min*60;
                            sec = sec%60;
                            String time = f.format(min) + ":" + f.format(sec);
                            text_6_1.setText(time);
                        }

                        @Override
                        public void onFinish() {
                            player_1.start();
                            vibrator_1.vibrate(VibrationEffect.createOneShot(5000, 250));
                            timer_btn_6_1.setText(R.string.Frying_the_brisket);
                            timer_btn_6_1.setBackgroundColor(Color.parseColor("#6750a4"));
                            Toast.makeText(getApplicationContext(), getString(R.string.Ready), Toast.LENGTH_SHORT).show();
                            timer14 = null;
                            text_6_1.setText("10:00");
                        }
                    };
                    timer14.start();
                }
            }
        });

        back_to_lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SIxthActivity.this, LunchActivity.class);
                startActivity(intent);
            }
        });

        language_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SIxthActivity.this, LanguageMainActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            recreate();
            Intent intent = new Intent(SIxthActivity.this, SIxthActivity.class);
            startActivity(intent);
            finish();
        }
    }
}