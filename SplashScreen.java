package com.example.dronedeliveryservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.dronedeliveryservice.R;
import com.example.dronedeliveryservice.MainActivity;

public class SplashScreen extends AppCompatActivity {
    TextView appname;
    LottieAnimationView lottie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        appname = findViewById(R.id.appname);
        lottie = findViewById(R.id.lottie);


        appname.animate().translationY(-200).setDuration(2700).setStartDelay(0);
        lottie.animate().setDuration(1500).setStartDelay(2900);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

            }
        },5000);
    }
}