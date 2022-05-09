package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ObjectInputStream;
import java.text.BreakIterator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Tamagochi extends AppCompatActivity {
    ImageButton store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamagochi);

        store = findViewById(R.id.tools_store);

        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intStore = new Intent(Tamagochi.this, Store.class);
                startActivity(intStore);
            }
        });

        //TextView textView = findViewById(R.id.test);
        Calendar c = Calendar.getInstance();
        //String time2 = String.format("%2d" , c.get(Calendar.HOUR_OF_DAY))+":"+String.format("%02d" , c.get(Calendar.MINUTE));

        SimpleDateFormat df1 = new SimpleDateFormat("hh:mm a");
        String strdate = df1.format(c.getTime());

        String st = strdate.replace(":","");
        String st1 = st.replace(" ","");
        String st2 = st1.substring(0,4);
        String substr1 = strdate.substring(6,8);

        int foo = Integer.parseInt(st2);

        String prayerTimes1 = "AM";
        int prayerTimes12 = 500;

        String prayerTimes2 = "PM";
        int prayerTimes22 = 900;

        if((substr1.equals(prayerTimes1) && foo<prayerTimes12) || (substr1.equals(prayerTimes2) && foo>prayerTimes22))
        {
           // textView.setText("st2");
        }

        final int[] time = {100};
        TextView textHealth = (TextView)findViewById(R.id.health);
        ProgressBar progressHealth = (ProgressBar)findViewById(R.id.vertical_progressbar1);
        TextView textEat = (TextView)findViewById(R.id.eat);
        ProgressBar progressEat = (ProgressBar)findViewById(R.id.vertical_progressbar2);
        TextView textHappy = (TextView)findViewById(R.id.happyness);
        ProgressBar progressHappy = (ProgressBar)findViewById(R.id.vertical_progressbar3);

        new CountDownTimer(100000, 1000) {

            public void onTick(long millisUntilFinished) {
                textHealth.setText(checkDigit(time[0]));
                progressHealth.setProgress(time[0]);
                textEat.setText(checkDigit(time[0]));
                progressEat.setProgress(time[0]);
                textHappy.setText(checkDigit(time[0]));
                progressHappy.setProgress(time[0]);
                time[0]--;
            }

            private String checkDigit(int time) {
                return String.valueOf(time);
            }

            public void onFinish() {
                textHealth.setText("0");
                textEat.setText("0");
                textHappy.setText("0");
            }

        }.start();




    }
}