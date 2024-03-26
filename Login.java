package com.me.wendesday_hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText password, emailid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        password = findViewById(R.id.pass);
        emailid = findViewById(R.id.email);



    }
}