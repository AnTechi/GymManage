package com.example.gymmanage;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Signup_fragment extends Fragment {


public static FragmentManager fragmentManager;
private Button signup_button,bnlogin;
EditText username,email,password,number;
    public Signup_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Database db=new Database(getActivity());

        View view= inflater.inflate(R.layout.fragment_signup_fragment, container, false);
        signup_button=view.findViewById(R.id.button_signup);
        bnlogin=view.findViewById(R.id.bnlogin_signup);
        username=view.findViewById(R.id.username_Signup);
        email=view.findViewById(R.id.email_signup);
        password=view.findViewById(R.id.password_signup);
        number=view.findViewById(R.id.phone_number);


        bnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new Login_fragment(),null).addToBackStack(null).commit();
            }
        });


        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String name = username.getText().toString();
                String Email = email.getText().toString();
                String pass = password.getText().toString();
                String num=number.getText().toString();


                Database database=new Database(getActivity());


                 if(name.equals("") || Email.equals("") || pass.equals("") || num.equals(""))
                 {
                     Toast.makeText(getActivity(), "Fill all fields" , Toast.LENGTH_LONG).show();
                 }
                 else {

                     boolean isinser = database.adduser(name, Email, pass, num);
                     if (isinser == true) {
                         Toast.makeText(getActivity(), "table created", Toast.LENGTH_LONG).show();
                         MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new Login_fragment(), null).addToBackStack(null).commit();
                     } else
                         Toast.makeText(getActivity(), "username already taken", Toast.LENGTH_LONG).show();


                     database.close();
                     username.setText("");
                     email.setText("");
                     password.setText("");
                     number.setText("");
                     //Toast.makeText(getActivity(),"contact saved",Toast.LENGTH_SHORT).show();



                 }

            }
        });

        return view;
    }



}
