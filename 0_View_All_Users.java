package com.me.hospital_crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.savedstate.SavedStateRegistryOwner;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class View_all extends AppCompatActivity {

    ListView list;
    Dbmanager db;
    Dbhelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        helper = new Dbhelper(this);
        db = new Dbmanager(this);
        db.open();
        viewAllUsers();
    }

    private void viewAllUsers() {
        list = findViewById(R.id.dataList);

        Cursor c = db.viewAllData();

        String[] from = {helper.name,helper.email, helper.password, helper.role};

        int[] to = {R.id.txtname,R.id.txtemail,R.id.txtpassword, R.id.txtrole};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,R.layout.cust_list,c,from,to);

        list.setEmptyView(findViewById(R.id.empty));
        adapter.notifyDataSetChanged();
        list.setAdapter(adapter);

    }
}
