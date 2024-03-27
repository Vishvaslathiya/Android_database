package com.me.hospital_crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.ContentView;

public class Dbmanager {

    Context context;
    Dbhelper helper;
    SQLiteDatabase db;


    public Dbmanager(Context c){
        this.context = c;
    }

    public Dbmanager open() throws SQLException{
        helper = new Dbhelper(context);
        db = helper.getWritableDatabase();
        return this;
    }

    public void close(){
        helper.close();
    }

// Add User Deatails to Databse

    public long add_UserDetails(String uname,String uemail, String upass, String ugender,String urole, String uvimo){
        ContentValues cv = new ContentValues();

        cv.put(helper.name,uname);
        cv.put(helper.email,uemail);
        cv.put(helper.password,upass);
        cv.put(helper.gender,ugender);
        cv.put(helper.role,urole);
        cv.put(helper.vimo,uvimo);

        long i = db.insert(helper.tblname,null,cv);
        return i;
    }

    public Cursor viewAllData(){
        Cursor c  = db.query(helper.tblname,null,null,null,null,null,null);
        return c;
    }

}

