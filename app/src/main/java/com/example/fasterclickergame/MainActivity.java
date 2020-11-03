package com.example.fasterclickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnCenterClick, btnStart, btnClickBottom;
    TextView tvTimeLeft, tvTotalClicks;
    int numberOfClicks = 0;
    int secondsLeft = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCenterClick = findViewById(R.id.btnCenterClick);
        btnStart = findViewById(R.id.btnStart);
        btnClickBottom = findViewById(R.id.btnClickBottom);

        tvTimeLeft = findViewById(R.id.tvTimeLeft);
        tvTotalClicks = findViewById(R.id.tvTotalClicks);

        btnCenterClick.setEnabled(false);

        final CountDownTimer timer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                secondsLeft--;
                tvTimeLeft.setText("Time Remaining: " + secondsLeft);
            }

            @Override
            public void onFinish() {
                btnCenterClick.setEnabled(false);
            }
        };

        btnCenterClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfClicks++;
                tvTotalClicks.setText("Number of clicks: " + numberOfClicks);
                btnClickBottom.setEnabled(true);
                btnCenterClick.setEnabled(false);
            }
        });

        btnClickBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfClicks++;
                tvTotalClicks.setText("Number of clicks: " + numberOfClicks);
                btnClickBottom.setEnabled(false);
                btnCenterClick.setEnabled(true);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondsLeft = 10;
                numberOfClicks = 0;
                btnCenterClick.setEnabled(true);
                timer.start();
            }
        });

    }
}