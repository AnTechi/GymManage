package com.example.gymmanage;


import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Login_fragment extends Fragment {
  private Button bnlogin;
  private EditText username_login,password_login;

  Database db;
  StringBuffer buffer;



    public Login_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login_fragment, container, false);
        bnlogin=view.findViewById(R.id.bnsearch_viewclient);
        username_login=view.findViewById(R.id.Name_viewclient);

        password_login=view.findViewById(R.id.number_viewclient);
        db=new Database(getActivity());


        readuse();


        return view;
    }
    public void readuse()
    {  buffer=new StringBuffer();

        bnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


             checkcredentials();




            }
        });


    }
    public void checkcredentials()
    {
        Cursor res=db.readinfo();
        String username=username_login.getText().toString();

        String pass=password_login.getText().toString();


        if(res.getCount()==0)
        {
            buffer.append("no data");


        }
        else
        {
            while(res.moveToNext())
            {

                if(res.getString(0).equals(username) && res.getString(2).equals(pass))
                   {
                     MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new Afterlogin_fragment(),null).addToBackStack(null).commit();
                   }


              else
                  {
                Toast.makeText(getActivity(), "Incorrect Username or Password", Toast.LENGTH_SHORT).show();
                username_login.setText("");
                password_login.setText("");
                  }

            }



        }
    }




}
