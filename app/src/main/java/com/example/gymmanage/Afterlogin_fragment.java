package com.example.gymmanage;


import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Afterlogin_fragment extends Fragment {
    private Button addclient,updateclient,viewall,viewmonthlyincome;
    private TextView amount;
    ClientDatabase db;


    public Afterlogin_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view=inflater.inflate(R.layout.fragment_afterlogin_fragment, container, false);
      addclient=view.findViewById(R.id.bnAddClient_afterlogin);
      viewmonthlyincome=view.findViewById(R.id.bntotalamt_afterlogin);
      viewall=view.findViewById(R.id.bnViewAll_afterlogin);
      updateclient=view.findViewById(R.id.bnUpdateClient_afterlogin);
      amount=view.findViewById(R.id.finalamount_afterlogin);
      db=new ClientDatabase(getActivity());
      monthlyincome();

      viewallclient();
      add();
      updateclient();
        return view;
    }

    public void add()
    {
      addclient.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new Addclients(),null).addToBackStack(null).commit();

          }
      });
    }

    public void viewallclient()
    {
        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new ViewInfo_fragment(),null).addToBackStack(null).commit();
            }
        });
    }

    public void updateclient()
    {
        updateclient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new UpdateClient(),null).addToBackStack(null).commit();
            }
        });
    }

    public void monthlyincome()
    {
        viewmonthlyincome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res=db.MonthlyIncomet();
                StringBuffer buffer=new StringBuffer();
                int amt=0;
                if(res.getCount()==0)
                {
                    Toast.makeText(getActivity(),"No Data",Toast.LENGTH_LONG).show();
                }
                else
                {
                    while(res.moveToNext())
                    {
                        amt=amt+Integer.parseInt(res.getString(0));
                        System.out.println(Integer.parseInt(res.getString(0)));

                    }
                    buffer.append(amt);
                    amount.setText(buffer);

                }


            }
        });
    }


}
