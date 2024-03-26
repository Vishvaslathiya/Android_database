package com.me.wendesday_hospital;

import androidx.appcompat.app.AppCompatActivity;

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
    Button register;
    RadioGroup radioGroup;
    RadioButton rbmale, rbfemale;
    Spinner role;
    CheckBox vimo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        onregister();
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


                // Concatenate all   into a single string
                String userInfo = "Name: " + name + "\n" +
                        "Password: " + pass + "\n" +
                        "Email: " + email + "\n" +
                        "Gender: " + gen + "\n" +
                        "User Role: " + userrole + "\n" +
                        "Insurance: " + insurence;

                 Toast.makeText(getApplicationContext(), userInfo, Toast.LENGTH_LONG).show();



            }
        });


    }

    private void initialize() {
        txtpass = findViewById(R.id.txtpass);
        txtname = findViewById(R.id.txtname);
        txtemail = findViewById(R.id.txtemail);

        register = findViewById(R.id.register);

        radioGroup = findViewById(R.id.radioGroup);
        rbmale = findViewById(R.id.rbmale);
        rbfemale = findViewById(R.id.rbfemale);

        role = findViewById(R.id.role);
        vimo = findViewById(R.id.vimo);
    }
}