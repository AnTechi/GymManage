package com.example.gymmanage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;

import java.io.File;

public class ClientDatabase extends SQLiteOpenHelper {



    private static final String DATABASE_NAME = "gym_info.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME_CLIENTS="client_details";

    private static final String CLIENT_ID="client_id";
    private static final String NAME="name";
    private static final String PHONENUMBER="phone_number";
    private static final String SEX="sex";
    private static final String JOINING_DATE="joining_date";
    private static final String ENDING_DATE="ending_date";
    private static final String AMOUNT="amount";




   public ClientDatabase (Context context){
       super(context,DATABASE_NAME,null,DATABASE_VERSION);
   }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME_CLIENTS + "(" +
                CLIENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME + " TEXT, " +
                PHONENUMBER + " TEXT, " +
                SEX + " TEXT, " +
                JOINING_DATE + " TEXT, " +
                ENDING_DATE + " TEXT, " +
                AMOUNT + " TEXT)"
        );
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME_CLIENTS);
onCreate(sqLiteDatabase);
    }

    //addusers

public  boolean addClientDetails(String Name,String Phonenumber,String Sex,String Joiningdate,String Endingdate,String Amount)
{
    SQLiteDatabase dB=this.getReadableDatabase();
    ContentValues contentValues=new ContentValues();

    contentValues.put(NAME,Name);
    contentValues.put(PHONENUMBER,Phonenumber);
    contentValues.put(SEX,Sex);
    contentValues.put(JOINING_DATE,Joiningdate);
    contentValues.put(ENDING_DATE,Endingdate);
    contentValues.put(AMOUNT,Amount);

    long result=dB.insert(TABLE_NAME_CLIENTS,null,contentValues);
    if(result==-1)
    {
        return false;
    }
    else
    {
        return true;
    }


}
//read database
    public Cursor readClientDetails()
    {   SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from "+TABLE_NAME_CLIENTS,null);
        return cursor;
    }

    //delete database

    public void DeleteClients(String name,String phonenumber)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME_CLIENTS+ " WHERE "+NAME+"='"+name+"' and"+ PHONENUMBER+"='"+phonenumber+"'",null);
        db.close();
    }

    //updateDatabase

    public boolean UpdateClients(String name, String phonenumber, String sex,String joiningdate,String endingdate,String amount){
       SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(PHONENUMBER,phonenumber);
        contentValues.put(SEX,sex);
        contentValues.put(JOINING_DATE,joiningdate);
        contentValues.put(ENDING_DATE,endingdate);
        contentValues.put(AMOUNT,amount);

       long result= db.update(TABLE_NAME_CLIENTS, contentValues, "NAME = ?",new String[] { name });

        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }


    }
//Search user
    public Cursor SearchClient(String name,String phonenumber){
       SQLiteDatabase db=this.getWritableDatabase();
       Cursor cursor=db.rawQuery("SELECT * FROM " + TABLE_NAME_CLIENTS + " where " + NAME + "='" + name + "' and " + PHONENUMBER + " = '" + phonenumber +"'", null);
return cursor;

    }

    //monthly income

    public Cursor MonthlyIncomet() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT " + AMOUNT + " FROM " + TABLE_NAME_CLIENTS, null);
        return res;
    }







}
