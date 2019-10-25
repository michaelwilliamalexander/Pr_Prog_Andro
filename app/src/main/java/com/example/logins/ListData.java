package com.example.logins;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListData extends Fragment{
    private SQLiteDatabase sqLiteDatabase;
    public static final String DATABASE_NAME="dataMahasiswa.db";
    public static final int DAATABASE_VERSION =1;
    private Button button;
    private  Button btn;
    private EditText nim;
    private EditText nama;
    private EditText email;

    public  EditText getNama(){
        return nama.findViewById(R.id.namaInput);
    }
    public  EditText getEmail(){
        return  email.findViewById(R.id.emailInput);
    }


    private ListAdapter listing;
    private RecyclerView recyclerView;
    private Cursor cursor;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View rootView = inflater.inflate(R.layout.fragment_datamahasiswa, container, false);
        recyclerView =  (RecyclerView) rootView.findViewById(R.id.recycMahasiswa);
        listing = new ListAdapter(getContext(),getAllItem());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(listing);

        button = (Button) rootView.findViewById(R.id.buatData);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nim= (EditText) rootView.findViewById(R.id.nimInput);
                nama = (EditText) rootView.findViewById(R.id.namaInput);
                email = (EditText) rootView.findViewById(R.id.emailInput);
                if (nim.getText().toString().trim().length() == 0 && nama.getText().toString().trim().length()==0 && email.getText().toString().trim().length()==0){
                    return;
                }
                String nims = nim.getText().toString();
                String namas = nama.getText().toString();
                String emails = email.getText().toString();
                ContentValues cv = new ContentValues();
                cv.put(DataMahasiswa.dataMahasiswa.COLUMN_NIM,nims);
                cv.put(DataMahasiswa.dataMahasiswa.COLUMN_NAMA,namas);
                cv.put(DataMahasiswa.dataMahasiswa.COLUMN_EMAIL,emails);
                sqLiteDatabase.insert(DataMahasiswa.dataMahasiswa.TABLE_NAME,null,cv);
                listing.swapCursor(getAllItem());
                nim.getText().clear();
                nama.getText().clear();
                email.getText().clear();
            }
        });
        return rootView;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseHelper dbMaster = new DatabaseHelper(getContext());
        sqLiteDatabase = dbMaster.getReadableDatabase();
    }


    private Cursor getAllItem(){
        return  sqLiteDatabase.query(
                DataMahasiswa.dataMahasiswa.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

}
