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

        bnsearch_updatefrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

searchClient();
            }
        });

    return view;
    }


    public void searchClient(){
        String Name="Rohit";
        String Phonenumber="9780";
//        String Gender=gender_tx.getText().toString();
//        String Joindate=joindate_tx.getText().toString();
//        String Enddate=enddate_tx.getText().toString();
//      String Amount=amount_tx.getText().toString();

//       name_tx.setText("");
//        phonenumber_tx.setText("");
//        joindate_tx.setText("");
//        enddate_tx.setText("");
//        gender_tx.setText("");
//        amount_tx.setText("");

Cursor cs=db.SearchClient(Name,Phonenumber);

if(cs.getCount()>0){

    Toast.makeText(getActivity(),"hoya",Toast.LENGTH_SHORT).show();
//    name_tx.setText("");
//    phonenumber_tx.setText("");


}
else{
    Toast.makeText(getActivity(),"ni",Toast.LENGTH_SHORT).show();
}
    }


}
