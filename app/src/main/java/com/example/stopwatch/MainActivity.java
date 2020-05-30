package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        TextView tvSplash, tvSubSplash;
        Button btnget;
        ImageView ivSplash;
        Animation atg,btgone,btgtwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSplash= findViewById(R.id.tvSplash);
        tvSubSplash=findViewById(R.id.tvSubSplash);
        btnget=findViewById(R.id.btnget);
        ivSplash=findViewById(R.id.ivSplash);

        //load Animations
        atg= AnimationUtils.loadAnimation(this, R.anim.atg);
        btgone= AnimationUtils.loadAnimation(this, R.anim.btgone);
        btgtwo=AnimationUtils.loadAnimation(this, R.anim.btgtwo);

        //passing animation
        ivSplash.startAnimation(atg);
        tvSplash.startAnimation(btgone);
        tvSubSplash.startAnimation(btgone);
        btnget.startAnimation(btgtwo);

        // passing event
        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent (MainActivity.this, StopAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        //importfont
        Typeface Mlight = Typeface.createFromAsset(getAssets(),  "Fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(),  "Fonts/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(),"Fonts/MRegular.ttf");

        //customize font
        tvSubSplash.setTypeface(Mlight);
        tvSplash.setTypeface(MRegular);
        btnget.setTypeface(MMedium);


    }
}