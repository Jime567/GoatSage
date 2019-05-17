package com.example.sageadvice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

public class databaseHelper extends SQLiteOpenHelper implements BaseColumns {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "UserManager.db";

    // User table name
    private static final String TABLE_USER = "user";

    // User Table Columns names
    static final String COLUMN_USER_NAME = "user_name";
    static final String COLUMN_USER_PASSWORD = "user_password";

    private static final String CREATE_USER_TABLE =
            "CREATE TABLE " + TABLE_USER + " (" + _ID +
                    " INTEGER PRIMARY KEY," +
                    COLUMN_USER_NAME + " TEXT," +
                    COLUMN_USER_PASSWORD + " TEXT)";


    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    public databaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);

        // Create tables again
        onCreate(db);

    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getUserName());

        values.put(COLUMN_USER_PASSWORD, user.getPassWord());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public boolean authenticateUser(String password, String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM user WHERE user_name=\'" + username + "\' AND user_password=\'" + password + "\'", null);

        if (c.getCount() > 0) {
            c.close();
            db.close();
            return true;
        } else {
            c.close();
            db.close();
            return false;
        }
    }

}



