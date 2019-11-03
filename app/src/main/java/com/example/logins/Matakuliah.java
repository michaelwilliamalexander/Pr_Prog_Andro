package com.example.logins;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

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
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager  layoutManager;
    private DatabaseReference databaseMatkul;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ){
        super.onCreateView(inflater, container, savedInstanceState);
        final View rootView = inflater.inflate(R.layout.fragment_matakuliah, container, false);
        recyclerView =  (RecyclerView) rootView.findViewById(R.id.recMatkul);
        inputSKS = rootView.findViewById(R.id.inputSKS);
        inputMatkul = rootView.findViewById(R.id.inputMatkul);
        inputNamaDosen = rootView.findViewById(R.id.inputNamaDosen);
        tmbhMAtkul = rootView.findViewById(R.id.tmbhMatkul);
        database = FirebaseFirestore.getInstance();
//        databaseMatkul = FirebaseDatabase.getInstance().getReference().child("Matakuliah");

        tmbhMAtkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputMatkul.getText().toString().isEmpty()) {
                    inputMatkul.setError("Masukan nama Matakuliah");
                    inputMatkul.requestFocus();
                } else if (inputSKS.getText().toString().isEmpty()) {
                    inputSKS.setError("Masukan SKS");
                    inputSKS.requestFocus();
                } else if (inputNamaDosen.getText().toString().isEmpty()) {
                    inputNamaDosen.setError("Masukan Nama Dosen");
                    inputNamaDosen.requestFocus();
                } else {
                    //RealTIme Database
//                    Matakuliahs mhs = new Matakuliahs(inputMatkul.getText().toString(),
//                            inputSKS.getText().toString(),inputNamaDosen.getText().toString());
//                    databaseMatkul.push().setValue(mhs);
                    //FireStore
                    Matakuliahs mhs = new Matakuliahs(inputMatkul.getText().toString(),
                            Integer.parseInt(inputSKS.getText().toString()), inputNamaDosen.getText().toString());
                    database.collection("Matakuliah").document().set(mhs)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(getContext(), "Data Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
                                    getDataMataKuliah();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                }
                            });
                    getDataMataKuliah();
                    inputMatkul.getText().clear();
                    inputSKS.getText().clear();
                    inputNamaDosen.getText().clear();
                }
            }
        });
        getDataMataKuliah();
        return rootView;
    }
    public void getDataMataKuliah() {
        final ArrayList<Matakuliahs> Matkul = new ArrayList<Matakuliahs>();
        Task<QuerySnapshot> docRef = database.collection("Matakuliah")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot doc : task.getResult()) {
                                Matakuliahs mataKuliah = new Matakuliahs();
                                mataKuliah.setMataKuliah(doc.get("mataKuliah").toString());
                                mataKuliah.setNamaDosen(doc.get("namaDosen").toString());
                                mataKuliah.setSks(((Long) doc.get("sks")).intValue());
                                Matkul.add(mataKuliah);
                            }
                            RecycleView_Matkul recycleAdapter = new RecycleView_Matkul(Matkul);
                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                            recyclerView.setAdapter(recycleAdapter);
                        } else {
                        }
                    }
                });

    }
    public void deleteData(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
    }
}
