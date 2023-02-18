package com.example.dronedeliveryservice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dronedeliveryservice.R;
import com.example.dronedeliveryservice.login;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
    private Button button2;

    TextInputLayout fullname_var,email_var,phonenumber_var,password_var;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fullname_var = findViewById(R.id.fullname_feild);
        email_var = findViewById(R.id.email_field);
        phonenumber_var = findViewById(R.id.phonenumber_feild);
        password_var = findViewById(R.id.password_input_field);

       /* button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });*/
    }



    public void registerbuttonclick(View view) {

        String fullname_ = fullname_var.getEditText().getText().toString();
        String email_ = email_var.getEditText().getText().toString();
        String phonenumber_ = phonenumber_var.getEditText().getText().toString();
        String password_ = password_var.getEditText().getText().toString();

        if (!fullname_.isEmpty()){
            fullname_var.setError(null);
            fullname_var.setErrorEnabled(false);
            if (!email_.isEmpty()){
                email_var.setError(null);
                email_var.setErrorEnabled(false);
                if (!phonenumber_.isEmpty()){
                    phonenumber_var.setError(null);
                    phonenumber_var.setErrorEnabled(false);
                    if (!password_.isEmpty()){
                        password_var.setError(null);
                        password_var.setErrorEnabled(false);

                        if (!email_.matches("\"[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$\"")){

                            firebaseDatabase = FirebaseDatabase.getInstance();
                            reference = firebaseDatabase.getReference("datauser");


                            String fullname_s = fullname_var.getEditText().getText().toString();
                            String email_s = email_var.getEditText().getText().toString();
                            String phonenumber_s = phonenumber_var.getEditText().getText().toString();
                            String password_s = password_var.getEditText().getText().toString();

                            storingdata storingdatass = new storingdata(fullname_s,email_s,phonenumber_s,password_s);

                            reference.child(fullname_s).setValue(storingdatass);


                            Toast.makeText(getApplicationContext(),"Register Successfully",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),login.class);
                            startActivity(intent);
                            finish();



                        }else {
                            email_var.setError("Invalid email");
                        }

                    }else {
                        password_var.setError("Please Enter the Password");
                    }
                }else {
                    phonenumber_var.setError("Please Enter the PhoneNumber");
                }
            }else {
                email_var.setError("Please Enter the Email");
            }
        }else {
            fullname_var.setError("Please Enter the FullName");
        }



    }
  /*  public void openActivity2() {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }*/
}