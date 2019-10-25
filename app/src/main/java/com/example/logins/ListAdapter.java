package com.example.logins;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private Context context;
    private Cursor cursor;

    public ListAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.listrecycle,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (!cursor.moveToPosition(position)){
            return;
        }
        String nim = cursor.getString(cursor.getColumnIndex(DataMahasiswa.dataMahasiswa.COLUMN_NIM ));
        String nama = cursor.getString(cursor.getColumnIndex(DataMahasiswa.dataMahasiswa.COLUMN_NAMA));
        String email = cursor.getString(cursor.getColumnIndex(DataMahasiswa.dataMahasiswa.COLUMN_EMAIL ));

        holder.nim.setText(nim);
        holder.nama.setText(nama);
        holder.email.setText(email);
    }

    @Override
    public int getItemCount() {
        return cursor.getCount() ;
    }

    public void swapCursor(Cursor newCursor){
        if (cursor!=null){
            cursor.close();
        }
        cursor = newCursor;

        if (newCursor != null){
            notifyDataSetChanged();
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nim;
        private TextView nama;
        private TextView email;
        public MyViewHolder(View view){
            super(view);
            nim =(TextView) view.findViewById(R.id.nimList);
            nama = (TextView) view.findViewById(R.id.namaList);
            email = (TextView) view.findViewById(R.id.emailList);
        }
    }


}
