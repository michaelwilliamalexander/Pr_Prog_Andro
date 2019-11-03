package com.example.logins;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class RecycleView_Matkul extends RecyclerView.Adapter<RecycleView_Matkul.MyViewHolder> {

    private List<Matakuliahs> data;
    private FirebaseFirestore database;


    public RecycleView_Matkul(List<Matakuliahs> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_matakuliah,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        database = FirebaseFirestore.getInstance();
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.namaMatkul.setText(data.get(position).getMataKuliah());
        final String tempt = data.get(position).getMataKuliah();
        holder.namaDosen.setText(data.get(position).getNamaDosen());
        holder.sks.setText(Integer.toString(data.get(position).getSks()));
        holder.hps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.collection("Matakuliah").document(tempt)
                        .delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        holder.namaDosen.setText("");
                        holder.sks.setText("");
                        holder.namaMatkul.setText("");
                    }
                });
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView namaMatkul;
        private TextView sks;
        private TextView namaDosen;
        private Button hps;

        public MyViewHolder(View view) {
            super(view);
            namaMatkul=(TextView) view.findViewById(R.id.NamaMatakuliah);
            sks = (TextView) view.findViewById(R.id.SKS);
            namaDosen =(TextView) view.findViewById(R.id.namaDosen);
            hps = view.findViewById(R.id.hapusMatkul);
        }
    }

}
