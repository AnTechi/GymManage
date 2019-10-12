package com.example.gymmanage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity  {
    public static FragmentManager fragmentManager;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new Database(this);


        fragmentManager=getSupportFragmentManager();

        if(findViewById(R.id.fragment_container)!=null)
        {
            if(savedInstanceState!=null){
                return;
            }
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            Signup_fragment signup_fragment=new Signup_fragment();
            fragmentTransaction.add(R.id.fragment_container,signup_fragment,null);
            fragmentTransaction.commit();
        }




    }




}
