package com.me.hospital_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtpass, txtname, txtemail;
    Button register,viewalldata;
    RadioGroup radioGroup;
    RadioButton rbmale, rbfemale;
    Spinner role;
    CheckBox vimo;
    Button btnmylogin;

    Dbhelper helper;
    Dbmanager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new Dbhelper(this);
        db = new Dbmanager(this);
        db.open();

        initialize();
        onregister();

        btnmylogin = findViewById(R.id.btnLogin);
        btnmylogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotologin();
            }
        });


        viewalldata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewallmyuser();
            }
        });
    }



    private void  gotologin(){
        Intent i = new Intent(MainActivity.this, Login.class);
        startActivity(i);
    }
    private void viewallmyuser() {
        Intent i = new Intent(MainActivity.this, View_all.class);
        startActivity(i);
    }


    private void onregister() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,pass,email,gen="",userrole,insurence;

                name = txtname.getText().toString();
                pass = txtpass.getText().toString();
                email = txtemail.getText().toString();
                userrole = role.getSelectedItem().toString();

                if(radioGroup.getCheckedRadioButtonId() == R.id.rbmale){
                    gen = "Male";
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.rbfemale) {
                    gen = "Female";
                }

                if(vimo.isChecked()){
                    insurence = "yes";
                }
                else {
                    insurence = "No";
                }


                long i = db.add_UserDetails(name,email,pass,gen,userrole,insurence);
                if( i > 0){
                    Toast.makeText(getApplicationContext(), "User Registered", Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(getApplicationContext(), "User Not Registered", Toast.LENGTH_LONG).show();

                }

                // Concatenate all   into a single string
//                String userInfo = "Name: " + name + "\n" +
//                        "Password: " + pass + "\n" +
//                        "Email: " + email + "\n" +
//                        "Gender: " + gen + "\n" +
//                        "User Role: " + userrole + "\n" +
//                        "Insurance: " + insurence;
//
//                Toast.makeText(getApplicationContext(), userInfo, Toast.LENGTH_LONG).show();

            }
        });




    }

    private void initialize() {
        txtpass = findViewById(R.id.txtpass);
        txtname = findViewById(R.id.txtname);
        txtemail = findViewById(R.id.txtemail);

        register = findViewById(R.id.register);
        viewalldata = findViewById(R.id.btnViewData);

        radioGroup = findViewById(R.id.radioGroup);
        rbmale = findViewById(R.id.rbmale);
        rbfemale = findViewById(R.id.rbfemale);

        role = findViewById(R.id.role);
        vimo = findViewById(R.id.vimo);
    }
}
