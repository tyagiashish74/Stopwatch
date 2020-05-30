package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopAct extends AppCompatActivity {

    Button btnstart,btnstop;
    ImageView icanchor;
    Animation roundingalone,stopanim;
    Chronometer timerHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop);

        btnstart=findViewById(R.id.btnstart);
        icanchor=findViewById(R.id.icanchor);
        btnstop=findViewById(R.id.btnstop);
        timerHere=findViewById(R.id.timerHere);


        //create optional Animation.After clicking btnstop the button will hide.
       // btnstop.setAlpha(0);

        //load animation
       roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);
        stopanim = AnimationUtils.loadAnimation(this, R.anim.stopanim);
        //import font
        Typeface MMedium = Typeface.createFromAsset(getAssets(),  "Fonts/MMedium.ttf");


        //customize font
        btnstart.setTypeface(MMedium);
        btnstop.setTypeface(MMedium);

        // on starting of application it will invisible the btnstop
        btnstop.setVisibility(View.INVISIBLE);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //passing Animation
                icanchor.startAnimation(roundingalone);

                // after clicking button stop the finish now button will get replaced by start now button
                //btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                //create optional Animation.After clicking btnstop the button will hide.
               // btnstart.animate().alpha(0).setDuration(300).start();

                // after clicking button start the stop button will get invisible .
                btnstart.setVisibility(View.INVISIBLE);

                //after clicking button start the button stop will visible. it will perform after upper case.
                btnstop.setVisibility(View.VISIBLE);

                // start time
                timerHere.setBase(SystemClock.elapsedRealtime());
                timerHere.start();
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //icanchor.startAnimation(roundingalone);
                btnstart.setVisibility(View.VISIBLE);
                timerHere.setBase(SystemClock.elapsedRealtime());
                timerHere.stop();
                //after clicking button stop the button stop will invisible.
                btnstop.setVisibility(View.INVISIBLE);
                //after clicking button stop the start button will visible.
                btnstart.setVisibility(View.VISIBLE);

                icanchor.startAnimation(stopanim);
            }
        });
       ;


            }
    }
