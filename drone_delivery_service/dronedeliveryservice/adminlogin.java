package com.example.dronedeliveryservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dronedeliveryservice.R;
import com.example.dronedeliveryservice.adminfrontend;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class adminlogin extends AppCompatActivity {
    private Button button3
           /* button1
           */         ;

    TextInputLayout username_var,password_var;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        username_var = findViewById(R.id.adminname);
        password_var = findViewById(R.id.adminpassword);

 /*       button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity6();}
        });*/
/*
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();}
        });
 */   }
/*

    private void openActivity1() {
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }
*/


    public void openActivity6() {
        Intent intent = new Intent(this, adminfrontend.class);
        startActivity(intent);
    }

    public void loginbuttonclick(View view) {

        String username_ = username_var.getEditText().getText().toString();
        String password_ = password_var.getEditText().getText().toString();
        if (!username_.isEmpty()){
            username_var.setError(null);
            username_var.setErrorEnabled(false);
            if (!password_.isEmpty()){
                password_var.setError(null);
                password_var.setErrorEnabled(false);

                final String username_data = username_var.getEditText().getText().toString();
                final String password_data = password_var.getEditText().getText().toString();

                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = firebaseDatabase.getReference("admin");
                DatabaseReference databaseReferenceadmin = firebaseDatabase.getReference("datauser");

                Query check_admin = databaseReference.orderByChild("name").equalTo(username_data);
                Query check_user = databaseReferenceadmin.orderByChild("email").equalTo(username_data);



                check_admin.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if (snapshot.exists()){
                            username_var.setError(null);
                            username_var.setErrorEnabled(false);
                            String passwordcheck = snapshot.child(username_data).child("password").getValue(String.class);
                            if (passwordcheck.equals(password_data)){
                                password_var.setError(null);
                                password_var.setErrorEnabled(false);

                                Toast.makeText(getApplicationContext(),"Admin Login successfully",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),adminfrontend.class);
                                startActivity(intent);
                                finish();

                            }else {
                                password_var.setError("Wrong password");
                            }
                        }else {
                            username_var.setError("Admin does not exists");
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }else {
                password_var.setError("Please Enter the Password");
            }
        }else {
            username_var.setError("Please Enter the Name");
        }

    }


}