package com.example.gymmanage;


import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLClientInfoException;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Addclients extends Fragment implements DatePickerDialog.OnDateSetListener {

//kk
    ClientDatabase db;
    private EditText name,phonenumber,gender,joindate,enddate,amount;
     private Button bnadd_addfrag,bndate_addfrag;
     private DatePickerDialog.OnDateSetListener mDateSetListener;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_addclients, container, false);

          db=new ClientDatabase(getActivity());
          name=view.findViewById(R.id.name_addclient);
        phonenumber=view.findViewById(R.id.phone_addclient);
        gender=view.findViewById(R.id.gender_addclient);
        joindate=view.findViewById(R.id.joiningdate_addclient);
        enddate=view.findViewById(R.id.endingdate_addclient);
        amount=view.findViewById(R.id.Amount_addclient);
         bnadd_addfrag=view.findViewById(R.id.bnadd_addclient);
bndate_addfrag=view.findViewById(R.id.date_button);
//bndate_addfrag.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//        DialogFragment datepicker=new android.app.DialogFragment();
//
//
//    }
//});

         bnadd_addfrag.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 addclient();
             }
         });



        return view;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {

    }

    public void addclient()
    {
         String Name=name.getText().toString();
        String Phonenumber=phonenumber.getText().toString();
        String Gender=gender.getText().toString();
        String Joindate=joindate.getText().toString();
        String Enddate=enddate.getText().toString();
        String Amount=amount.getText().toString();


        if(Name.equals("") || Phonenumber.equals("") || Gender.equals("") || Joindate.equals("") || Enddate.equals("") || Amount.equals(""))
        {
            Toast.makeText(getActivity(), "Fill all fields" , Toast.LENGTH_LONG).show();
        }
        else
        {
            boolean isinsert=db.addClientDetails(Name,Phonenumber,Gender,Joindate,Enddate,Amount);

            if(isinsert==true)
            {
                Toast.makeText(getActivity(),"Data inserted",Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(getActivity(),"Data not inserted",Toast.LENGTH_LONG).show();

            name.setText("");
            phonenumber.setText("");
            gender.setText("");
            joindate.setText("");
            enddate.setText("");
            amount.setText("");


        }
        db.close();





    }

}
