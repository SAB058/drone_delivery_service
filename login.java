package com.example.dronedeliveryservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {
    private Button button,button3,adminlogin;

    TextInputLayout username_var,password_var;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        username_var = findViewById(R.id.username_text_field_design);
        password_var = findViewById(R.id.password_input_field);


 /*       button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username_ = username_var.getEditText().getText().toString();
                String password_ = password_var.getEditText().getText().toString();
                if (!username_.isEmpty()){
                    username_var.setError(null);
                    username_var.setErrorEnabled(false);
                    if (!password_.isEmpty()){
                        password_var.setError(null);
                        password_var.setErrorEnabled(false);
                    }else {
                        password_var.setError("Please Enter the Password");
                    }
                }else {
                    username_var.setError("Please Enter the Password");
                }
            }
        });
*/
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();}
        });

        adminlogin = (Button) findViewById(R.id.adminlogin);
        adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity9();}
        });

/*

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });
*/

    }

   public void openActivity1() {
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }

    public void openActivity9() {
        Intent intent = new Intent(this, adminlogin.class);
        startActivity(intent);
    }

 /*   public void openActivity2() {

        Intent intent = new Intent(this, frontend.class);
        startActivity(intent);
    }
*/

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
                DatabaseReference databaseReference = firebaseDatabase.getReference("datauser");
                DatabaseReference databaseReferenceadmin = firebaseDatabase.getReference("admin");

                Query check_user = databaseReference.orderByChild("name").equalTo(username_data);
                Query check_admin = databaseReferenceadmin.orderByChild("email").equalTo(username_data);



                check_user.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if (snapshot.exists()){
                            username_var.setError(null);
                            username_var.setErrorEnabled(false);
                            String passwordcheck = snapshot.child(username_data).child("password").getValue(String.class);
                            if (passwordcheck.equals(password_data)){
                                password_var.setError(null);
                                password_var.setErrorEnabled(false);

                                Toast.makeText(getApplicationContext(),"Login successfully",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),frontend.class);
                                startActivity(intent);
                                finish();

                            }else {
                                password_var.setError("Wrong password");
                            }
                        }else {
                            username_var.setError("User does not exists");
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
            username_var.setError("Please Enter the Email");
        }

    }
}