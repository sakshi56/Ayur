package com.example.ayur;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Models extends Fragment {
    View view;

    public List<ListItems> mylist = new ArrayList<>();
    //    private RecyclerView recyclerView;
    private RecyclerAdapter mAdapter;

    public Models(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.models,container,false);

        RecyclerView list = (RecyclerView) view.findViewById(R.id.recycler);
        mAdapter = new RecyclerAdapter(getContext(),mylist);

        list.setLayoutManager(new LinearLayoutManager(getContext()));
        prepareData();

        mAdapter.setIt(mylist);
        list.setAdapter(mAdapter);

        return view;
    }
    public void prepareData()
    {
        ListItems items = new ListItems( R.drawable.pocof," Xiaomi Redmi Poco F1");
        mylist.add(items);

        items = new ListItems(R.drawable.note5,"Xiaomi Redmi Note 5");
        mylist.add(items);

        items = new ListItems(R.drawable.note6,"Xiaomi Redmi Note 6");
        mylist.add(items);

        items = new ListItems(R.drawable.note7,"Xiaomi Redmi Note 7");
        mylist.add(items);
    }
}