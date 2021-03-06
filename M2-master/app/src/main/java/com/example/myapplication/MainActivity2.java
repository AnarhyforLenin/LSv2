package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.pdf.PdfRenderer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {


    static String name = "";
    static int var = 12;
    TextView q1,q2,right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        int[] photos={R.drawable.f1, R.drawable.f2, R.drawable.f3, R.drawable.f4, R.drawable.f5, R.drawable.f6, R.drawable.f7, R.drawable.f8, R.drawable.f9, R.drawable.f100, R.drawable.f110, R.drawable.f120, R.drawable.f130, R.drawable.f140, R.drawable.f150};

        //blue -1
        //yellow -2
        //green -3
        //red -4

        int[] f1 = {3,1};
        int[] f2 = {3,2};
        int[] f3 = {3,3};
        int[] f4 = {4,3};
        int[] f5 = {4,1};
        int[] f6 = {4,2};
        int[] f7 = {4,4};
        int[] f8 = {5,4};
        int[] f9 = {5,2};
        int[] f10 = {5,3};
        int[] f11 = {5,1};
        int[] f12 = {6,1};
        int[] f13 = {6,2};
        int[] f14 = {6,3};
        int[] f15 = {6,4};

        int[][] mas = {f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15};

        ImageView image1 = (ImageView) findViewById(R.id.f10);

        q1=findViewById(R.id.q1);
        q2=findViewById(R.id.q2);

        int ranq1 = (int)(Math.random()*((6-3)+1))+3;
        switch (ranq1) {
            case 3:
                q1.setText("?????????????? ???? ???????????? ???????????????????????????");
                break;
            case 4:
                q1.setText("?????????????? ???? ???????????? ???????????????????");
                break;
            case 5:
                q1.setText("?????????????? ???? ???????????? ?????????????????????????????");
                break;
            case 6:
                q1.setText("?????????????? ???? ???????????? ???????????????????????????????");
                break;
            default:
                break;

        }


        int ranq2 = (int)(Math.random()*((4-1)+1))+1;

        Random ran1=new Random();
        int i1=ran1.nextInt(photos.length);
        image1.setImageResource(photos[i1]);

        ImageView image2 = (ImageView) findViewById(R.id.f11);

        Random ran2=new Random();
        int i2=ran2.nextInt(photos.length);
        image2.setImageResource(photos[i2]);

        ImageView image3 = (ImageView) findViewById(R.id.f12);

        Random ran3=new Random();
        int i3=ran2.nextInt(photos.length);
        image3.setImageResource(photos[i3]);

        ImageView image4 = (ImageView) findViewById(R.id.f20);

        Random ran4=new Random();
        int i4=ran4.nextInt(photos.length);
        image4.setImageResource(photos[i4]);

        ImageView image5 = (ImageView) findViewById(R.id.f21);

        Random ran5=new Random();
        int i5=ran5.nextInt(photos.length);
        image5.setImageResource(photos[i5]);

        ImageView image6 = (ImageView) findViewById(R.id.f22);

        Random ran6=new Random();
        int i6=ran6.nextInt(photos.length);
        image6.setImageResource(photos[i6]);

        int counterA1 = 0;
        int counterA2 = 0;
        if (mas[i1][0]==ranq1) { counterA1+=1;}
        if (mas[i2][0]==ranq1) { counterA1+=1;}
        if (mas[i3][0]==ranq1) { counterA1+=1;}
        if (mas[i4][0]==ranq1) { counterA1+=1;}
        if (mas[i5][0]==ranq1) { counterA1+=1;}
        if (mas[i6][0]==ranq1) { counterA1+=1;}

        if (mas[i1][1]==ranq2) { counterA2+=1;}
        if (mas[i2][1]==ranq2) { counterA2+=1;}
        if (mas[i3][1]==ranq2) { counterA2+=1;}
        if (mas[i4][1]==ranq2) { counterA2+=1;}
        if (mas[i5][1]==ranq2) { counterA2+=1;}
        if (mas[i6][1]==ranq2) { counterA2+=1;}

        while (counterA2==0 && counterA1==0){
            ranq2= (int)(Math.random()*((4-1)+1))+1;

        }

        switch (ranq2) {
            case 1:
                q2.setText("?????????????? ???? ???????????? ?????????? ???????????");
                break;
            case 2:
                q2.setText("?????????????? ???? ???????????? ???????????? ???????????");
                break;
            case 3:
                q2.setText("?????????????? ???? ???????????? ?????????????? ???????????");
                break;
            case 4:
                q2.setText("?????????????? ???? ???????????? ?????????????? ???????????");
                break;
            default:
                break;

        }


        final boolean[] Fanswer1 = {false};
        final boolean[] Fanswer2 = {false};

        SeekBar seekBar = findViewById(R.id.s1);
        TextView a1 = findViewById(R.id.a1);
        right = findViewById(R.id.right2);
        int finalCounterA = counterA1;
        final int[] answer1 = {0};
        SeekBar.OnSeekBarChangeListener seekBarOnClickListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                a1.setText(String.valueOf(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                answer1[0] = Integer.valueOf(a1.getText().toString());
                if (answer1[0] == finalCounterA) {
                    Fanswer1[0] = true;
                    if (Fanswer2[0]) {
                        if (var == 10) {
                            rightSetText("???? ??????????????," + name + "!\n?????????????? ???????");

                            showAlertDialog();
                        }
                        if (var == 11) {
                            rightSetText("???? ??????????????," + name + "!\n?????????????? ???????");

                            showAlertDialog();
                        }
                        if (var == 12) {
                            rightSetText("???? ??????????????, ????????????! ?????????????? ???????");

                            showAlertDialog();
                        }
                        //findViewById(R.id.right2).setVisibility(View.VISIBLE);
                    }

                }


            }
        };
        seekBar.setOnSeekBarChangeListener(seekBarOnClickListener);
        SeekBar seekBar2 = findViewById(R.id.s2);
        TextView a2 = findViewById(R.id.a2);
        int finalCounterA2 = counterA2;
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
                a2.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar2) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar2) {
                answer1[0] = Integer.valueOf(a2.getText().toString());
                if (answer1[0]== finalCounterA2) {
                    Fanswer2[0] = true;
                    if (Fanswer1[0]) {
                        if (var ==10) {
                            rightSetText("???? ??????????????,"+name+"!");

                            showAlertDialog();
                        }
                        if (var==11) {
                            rightSetText("???? ??????????????,"+name+"!");

                            showAlertDialog();

                        }
                        if (var==12) {
                            rightSetText("???? ??????????????, ????????????!");

                            showAlertDialog();



                        }

                    }
                }

            }
        });
    }

    private void rightSetText(String text) {
        right.setText(text);
        right.postInvalidate();
    }

    public void showAlertDialog()  {


        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("?????????????? ???????)");

        // add the buttons
        builder.setPositiveButton("????!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intentBreath = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intentBreath);
            }
        });
        builder.setNeutralButton("?????? ?????? ???? ?????? ????????????????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intentGood = new Intent(MainActivity2.this, MainScreen.class);
                startActivity(intentGood);
            }
        });
        builder.setNegativeButton("??????, ?? ?????? ???? ?????????????? ??????????????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent( MainActivity2.this , MainActivity2.class );

                startActivity(i);
            }
        });


        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();

    }


}