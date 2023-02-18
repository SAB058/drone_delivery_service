package com.example.dronedeliveryservice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class role extends AppCompatActivity {
    private Button button5,button6;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity4();
            }
        });

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity5();
            }
        });

    }

    public void openActivity4() {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

    public void openActivity5() {
        Intent intent = new Intent(this, adminlogin.class);
        startActivity(intent);
    }

}
