package com.me.hospital_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText inpname, inppass;
    Button btnlogin;
    Dbmanager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inpname = findViewById(R.id.inpname);
        inppass = findViewById(R.id.inppass);
        btnlogin = findViewById(R.id.btnLogin1);

        db = new Dbmanager(this);
        db.open();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = inpname.getText().toString();
                String password = inppass.getText().toString();

                if (validateLogin(username, password)) {
                    // User exists, navigate to Dashboard
                    Intent intent = new Intent(Login.this, View_all.class);
                    startActivity(intent);
                } else {
                    // User does not exist, display message
                    Toast.makeText(Login.this, "Please register first", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateLogin(String username, String password) {
        Cursor cursor = db.viewAllData();

        while (cursor.moveToNext()) {
            String dbUsername = cursor.getString(cursor.getColumnIndex(Dbhelper.name));
            String dbPassword = cursor.getString(cursor.getColumnIndex(Dbhelper.password));

            if (dbUsername.equals(username) && dbPassword.equals(password)) {
                return true; // User exists in the database
            }
        }

        return false; // User not found in the database
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}
