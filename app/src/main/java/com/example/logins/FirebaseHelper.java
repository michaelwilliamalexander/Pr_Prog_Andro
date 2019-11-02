package com.example.logins;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseHelper {
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private List<Matakuliahs> mataKuliah = new ArrayList<>();

    public interface DataStatus{
        void DataisLoaded(List<Matakuliahs> matakuliahData, List<String> keys);
        void DataisInserted();
        void DataisUpdated();
        void DataisDeleted();
    }
    public FirebaseHelper(){
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Matakuliah");
    }

    public void  readData(final DataStatus dataStatus){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mataKuliah.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode: dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Matakuliahs data = keyNode.getValue(Matakuliahs.class);
                    mataKuliah.add(data);
                }
                dataStatus.DataisLoaded(mataKuliah,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
