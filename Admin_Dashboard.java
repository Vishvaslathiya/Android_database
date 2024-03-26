package com.me.wendesday_hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Admin_Dashboard extends AppCompatActivity {

    ListView users ;
    Dbmanager db;
    Dbhelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        helper = new Dbhelper(this);
        db = new Dbmanager(this);
        db.open();
        users = findViewById(R.id.list_users1);
        getUserList();
    }

    private void getUserList() {
        users = findViewById(R.id.list_users1);

        Cursor c = db.viewAllData();
        String[] from = {helper.name, helper.role, helper.gender, helper.vimo, helper.password};
        int[] to = {R.id.opuname, R.id.oprole ,R.id.opgender , R.id.opvimo,  R.id.oppassword};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,R.layout.cust_list_view,c,from,to);

            users.setEmptyView(findViewById(R.id.empty));
            adapter.notifyDataSetChanged();
            users.setAdapter(adapter);



    }
}