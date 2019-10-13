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
public class UpdateClient extends Fragment {
    ClientDatabase db;
private Button bnsearch_updatefrag,bnupdate_updatefrag,bndelete_updatefrag;
private EditText name_tx,phonenumber_tx,gender_tx,enddate_tx,joindate_tx,amount_tx;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update_client, container, false);
        db=new ClientDatabase(getActivity());
        name_tx=view.findViewById(R.id.name_updateclient);
        bnsearch_updatefrag=view.findViewById(R.id.bnsearch_updateclient);
        bnsearch_updatefrag=view.findViewById(R.id.bnsearch_updateclient);
        phonenumber_tx=view.findViewById(R.id.phone_updateclient);
        gender_tx=view.findViewById(R.id.gender_updateclient);
        joindate_tx=view.findViewById(R.id.joiningdate_updateclient);
        enddate_tx=view.findViewById(R.id.endingdate_updateclient);
        amount_tx=view.findViewById(R.id.Amount_updateclient);
        bndelete_updatefrag=view.findViewById(R.id.bndelete_updateclient);
searchClient();
        deleteClient();



    return view;
    }


    public void searchClient(){
        bnsearch_updatefrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name=name_tx.getText().toString();
                String Phonenumber=phonenumber_tx.getText().toString();

                Cursor cs=db.SearchClient(Name,Phonenumber);
                while (cs.moveToNext()){
                    name_tx.setText(cs.getString(1));
                    phonenumber_tx.setText(cs.getString(2));
                    gender_tx.setText(cs.getString(3));
                    joindate_tx.setText(cs.getString(4));
                    enddate_tx.setText(cs.getString(5));
                    amount_tx.setText(cs.getString(6));
                }

            }
        });



    }



public void deleteClient() {
    bndelete_updatefrag.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String name = name_tx.getText().toString();
            String phonenumber = phonenumber_tx.getText().toString();
            db.DeleteClients(name, phonenumber);


            name_tx.setText("");
            phonenumber_tx.setText("");
            gender_tx.setText("");
            joindate_tx.setText("");
            enddate_tx.setText("");
            amount_tx.setText("");
            Toast.makeText(getActivity(), "deleted", Toast.LENGTH_LONG).show();

        }
    });



}
}
