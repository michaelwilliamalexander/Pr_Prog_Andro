package com.example.logins;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class RecycleView_Matkul{
    private Context context;
    private List<Matakuliahs> data;
    private List<String> mkeys;
    private MatkulAdapter matkul;

    public void setConfig(RecyclerView recyclerView, Context context, List<Matakuliahs> data, List<String> key){
        this.context = context;
        this.matkul = new MatkulAdapter(data,key);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(this.matkul);
    }

    class ListMatakuliah extends RecyclerView.ViewHolder {
        private TextView namaMatkul;
        private TextView sks;
        private TextView namaDosen;
        private String keys;


        public ListMatakuliah(@NonNull ViewGroup view) {
            super(LayoutInflater.from(context).inflate(R.layout.recycleview_matakuliah,view,false));
            namaMatkul=(TextView) view.findViewById(R.id.NamaMatakuliah);
            sks = (TextView) view.findViewById(R.id.SKS);
            namaDosen =(TextView) view.findViewById(R.id.namaDosen);
        }

        public void  bind(Matakuliahs data, String key){
            namaMatkul.setText(data.getMataKuliah());
            sks.setText(data.getSks());
            namaDosen.setText(data.getNamaDosen());
            this.keys = key;
        }
    }

    class MatkulAdapter extends RecyclerView.Adapter<ListMatakuliah>{
        private List<Matakuliahs> data;
        private List<String> mkeys;

        public MatkulAdapter(List<Matakuliahs> data, List<String> mkeys) {
            this.data = data;
            this.mkeys = mkeys;
        }

        @Override
        public ListMatakuliah onCreateViewHolder( ViewGroup parent, int viewType) {
            return new ListMatakuliah(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ListMatakuliah holder, int position) {
            holder.bind(data.get(position),mkeys.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }






}
