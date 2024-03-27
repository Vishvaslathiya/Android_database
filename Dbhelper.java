package com.me.hospital_crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelper extends SQLiteOpenHelper {

    private static final String dbname="Wendesdat.db";
    private static final int version= 1 ;

    public static final String tblname = "tblHosptial";

    // fields

    public static final String id = "_id";

    public static final String name = "name";
    public static final String email = "email";
    public static final String password = "password";
    public static final String gender = "gender";
    public static final String role = "role";
    public static final String vimo = "vimo";


    private static final String create_table= "create table " + tblname +
            "( "
            +id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + name + " Text, "
             + email + " Text, " +
              password + " Text, " +
              gender + " Text,"+
              role + " Text, " +
              vimo + " Text " +
            "  ); ";



    public Dbhelper(@Nullable Context context) {
        super(context, dbname, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tblname);
        onCreate(db);
    }
}

