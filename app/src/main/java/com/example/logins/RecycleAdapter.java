package com.example.logins;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {

    private Context context;
    private List<HomeRecycle> data;

    public RecycleAdapter(Context context, List<HomeRecycle> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.home_recycle,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.judul.setText(data.get(position).getJudul());
        holder.nama.setText(data.get(position).getNama());
        holder.gambaricon.setImageResource(data.get(position).getFoto());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView judul;
        private TextView nama;
        private ImageView gambaricon;
        public MyViewHolder(View view){
            super(view);
            judul=(TextView) view.findViewById(R.id.judul);
            nama = (TextView) view.findViewById(R.id.nama);
            gambaricon =(ImageView) view.findViewById(R.id.gamabrIcon);
        }
    }
}
