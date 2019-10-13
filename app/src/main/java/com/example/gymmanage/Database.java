package com.example.gymmanage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.io.File;

public class Database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="gym.db";
    public static final int DATABASE_VERSION=1;
    public static final String TABLE_NAME="user_data";

    public static final String username="user_name";
    public static final String email="email_id";
    public static final String Password="password";
    public static final String Number="number";




    public static final String DROP_TABLE="drop table if exists " + TABLE_NAME;

    public Database (Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.d("DATABASE OPERATIONS","DATABASE CREATED....");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


         sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (user_name TEXT PRIMARY KEY,email_id TEXT,password TEXT,number INTEGER)");
         Log.d("DATABASE OPERATIONS","TABLE CREATED....");



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
       sqLiteDatabase.execSQL(DROP_TABLE);
       onCreate(sqLiteDatabase);
    }

    public boolean adduser(String name,String Email,String password,String num)
    {    SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();


        contentValues.put(username,name);
        contentValues.put(email,Email);
        contentValues.put(Password,password);
        contentValues.put(Number,num);



        long result=db.insert(TABLE_NAME,null,contentValues);
         if(result==-1)
         {
             return false;
         }
         else
         {
             return true;
         }
    }

    public Cursor readinfo()
    {   SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from "+TABLE_NAME,null);
        return cursor;
    }
    public Integer Deleteuser()
    {
        SQLiteDatabase db=this.getWritableDatabase();

        return db.delete(TABLE_NAME, "1",null);

    }
    public void Deletetable()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.close();
        db.deleteDatabase(new File("gym.db"));
    }


}
