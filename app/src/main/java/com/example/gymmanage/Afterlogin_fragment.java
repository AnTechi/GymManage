package com.example.gymmanage;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Afterlogin_fragment extends Fragment {
    private Button addclient,viewclient,deleteclient,updateclient,viewall;


    public Afterlogin_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view=inflater.inflate(R.layout.fragment_afterlogin_fragment, container, false);
      addclient=view.findViewById(R.id.bnAddClient_afterlogin);
      viewclient=view.findViewById(R.id.bnViewClient_afterlogin);
      viewall=view.findViewById(R.id.bnViewAll_afterlogin);
      updateclient=view.findViewById(R.id.bnUpdateClient_afterlogin);

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

}
