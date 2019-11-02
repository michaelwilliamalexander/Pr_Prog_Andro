package com.example.logins;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class Matakuliah extends Fragment {
    private EditText inputNamaDosen;
    private EditText inputSKS;
    private EditText inputMatkul;
    private FirebaseFirestore database;
    private Button tmbhMAtkul;
    private List<Matakuliahs> data = new ArrayList<>();
    private RecyclerView recyclerView;
    private DatabaseReference databaseMatkul;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ){
        super.onCreateView(inflater, container, savedInstanceState);
        final View rootView = inflater.inflate(R.layout.fragment_matakuliah, container, false);
        inputSKS = rootView.findViewById(R.id.inputSKS);
        inputMatkul = rootView.findViewById(R.id.inputMatkul);
        inputNamaDosen = rootView.findViewById(R.id.inputNamaDosen);
        tmbhMAtkul = rootView.findViewById(R.id.tmbhMatkul);
        databaseMatkul = FirebaseDatabase.getInstance().getReference().child("Matakuliah");
        tmbhMAtkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputMatkul.getText().toString().isEmpty()){
                    inputMatkul.setError("Masukan nama Matakuliah");
                    inputMatkul.requestFocus();
                }else if(inputSKS.getText().toString().isEmpty()){
                    inputSKS.setError("Masukan SKS");
                    inputSKS.requestFocus();
                }else if(inputNamaDosen.getText().toString().isEmpty()){
                    inputNamaDosen.setError("Masukan Nama Dosen");
                    inputNamaDosen.requestFocus();
                }else{
                    Matakuliahs mhs = new Matakuliahs(inputMatkul.getText().toString(),
                            Integer.parseInt(inputSKS.getText().toString()),inputNamaDosen.getText().toString());
                    databaseMatkul.push().setValue(mhs);
                    inputMatkul.getText().clear();
                    inputSKS.getText().clear();
                    inputNamaDosen.getText().clear();
                    Toast.makeText(getContext(),"Data Berhasil Ditambahkan",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return rootView;
    }

}
