package com.example.logins;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {
    private RecyclerView recyclerView;
    private List<HomeRecycle> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ){
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_home_activity, container, false);
        recyclerView =  (RecyclerView) rootView.findViewById(R.id.fragRecycle);
        RecycleAdapter recycleAdapter = new RecycleAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycleAdapter);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list = new ArrayList<>();
        list.add(new HomeRecycle("Avenger End Game","Iron Man",R.drawable.ic_insert_smile));
        list.add(new HomeRecycle("Thor","Dewa Petir", R.drawable.ic_insert_smile));
        list.add(new HomeRecycle("The Last Airbender","AAG",R.drawable.ic_insert_smile));
    }
}
