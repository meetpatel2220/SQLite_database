package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Handler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "UserManager.db";

    // User table name
    private static final String TABLE_USER = "user";

    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";

    private static final String COLUMN_USER_ID = "user_id";

    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";

    public Handler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void adduser(Model model){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_USER_EMAIL,model.getEmail());
        contentValues.put(COLUMN_USER_PASSWORD,model.getPassword());

        sqLiteDatabase.insert(TABLE_USER,null,contentValues);
        sqLiteDatabase.close();


    }
public boolean checkUser(String email,String password) {

    String[] colums = {COLUMN_USER_ID};

    SQLiteDatabase db = this.getReadableDatabase();
    String selection = COLUMN_USER_EMAIL + "- ?" + " AND " + COLUMN_USER_PASSWORD + "- ?";

    String[] selectionArgs = {email, password};

    Cursor cursor = db.query(TABLE_USER,
            colums, selection, selectionArgs, null, null, null
    );

    int cursorcount = cursor.getCount();
    cursor.close();
    db.close();
    if (cursorcount > 0) {
        return true;
    } else {
        return false;
    }
}
}
