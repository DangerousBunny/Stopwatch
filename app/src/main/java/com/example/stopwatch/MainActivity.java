package com.example.stopwatch;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    private Chronometer stopwatch;
    private long pauseoffset;
    private boolean jalan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stopwatch = findViewById(R.id.stopwatch);
    }

    public  void  StartStopwatch(View v){
        if(!jalan){
            stopwatch.setBase(SystemClock.elapsedRealtime() - pauseoffset);
            stopwatch.start();
            jalan = true;
        }
    }

    public void  PauseStopwatch(View v){
        if(jalan){
            stopwatch.stop();
            pauseoffset = SystemClock.elapsedRealtime() - stopwatch.getBase();
            jalan = false;
        }
    }

    public void ResetStopwatch(View v){
            stopwatch.setBase(SystemClock.elapsedRealtime());
            pauseoffset = 0;
    }
}
