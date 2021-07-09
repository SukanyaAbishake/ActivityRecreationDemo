package com.example.activityrecreationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    Thread counterThread;
    int count = 0;
    boolean isCounterProgress;

    Button startButton, stopButton;
    TextView textViewCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");


        startButton = findViewById(R.id.bt_start);
        stopButton = findViewById(R.id.bt_stop);
        textViewCounter = findViewById(R.id.tv_counter);

        counterThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isCounterProgress) {
                    try {
                        Thread.sleep(1000);
                        count++;
                        textViewCounter.post(new Runnable() {
                            @Override
                            public void run() {
                                textViewCounter.setText("Counter:" + count);
                            }
                        });
                    } catch (Exception e) {

                    }
                }
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCounterProgress = true;
                Log.d(TAG,"Thread State::"+counterThread.getState());
                counterThread.start();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCounterProgress = false;
                //counterThread.stop();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
}