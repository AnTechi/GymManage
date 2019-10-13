package com.example.gymmanage;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewInfo_fragment extends Fragment {

    private TextView txt_display;
    ClientDatabase db;
    StringBuffer buffer;
    public ViewInfo_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_view_info_fragment, container, false);
        txt_display=view.findViewById(R.id.display_info);
         db=new ClientDatabase(getActivity());
         buffer=new StringBuffer();
         readuse();
         txt_display.setText(buffer.toString()+ "\n");
        return view;


    }
    public StringBuffer readuse()
    {
        Cursor res=db.readClientDetails();


        if(res.getCount()==0)
        {
            buffer.append("no data");

        }
        else
        {
            while(res.moveToNext()) {
                buffer.append("Id :" + res.getString(0) + ", ");
                buffer.append("Name :" + res.getString(1) + ", ");
                buffer.append("Phone :" + res.getString(2) + ", ");
                buffer.append("Gender :" + res.getString(3) + ", ");
                buffer.append("Join date :" + res.getString(4) + ", ");
                buffer.append("End date :" + res.getString(5) + ", ");
                buffer.append("Amount :" + res.getString(6) + "\n\n");
            }



        }
        return buffer;
    }


}
