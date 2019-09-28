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
        list.add(new HomeRecycle("Xmen Dark Phoenix","20th Century Fox",R.drawable.xmen));
        list.add(new HomeRecycle("The Amazing Spiderman","Sony Picture", R.drawable.spiderman));
        list.add(new HomeRecycle("Pokemon Detective Pikachu","Warner Bros",R.drawable.pikachu));
        list.add(new HomeRecycle("Skyfall","20th Century Fox",R.drawable.skyfall));
        list.add(new HomeRecycle("Assassin's Creed ","20th Century Fox", R.drawable.assasin));
        list.add(new HomeRecycle("Captain America : Civil War","Marvel Studio",R.drawable.civilwar));
        list.add(new HomeRecycle("Suicide Squad","DC Entertainment",R.drawable.suicidesquad));
        list.add(new HomeRecycle("John Wick","Warner Bros", R.drawable.johnwick));
        list.add(new HomeRecycle("Thor Ragnarok","Marvel Studio",R.drawable.thor1));
        list.add(new HomeRecycle("John Wick 3 Parabellum","20th Century Fox",R.drawable.johnwick3));
    }
}
