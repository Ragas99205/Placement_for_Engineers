package com.dzone.placement_for_engineers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlacementConHRFragment extends Fragment {
    private RecyclerView recyclerView;
    private PlacementConAdapter adapter;
    private List<PlacementConRecyclerItems> listItems;

    String name[] = {"Meera Enterprises",
            "Jurist Zone",
            "Excelindia HR Services",
            "Klaxon India",
            "Nidhi Maritime Consultancy",
            "Shrever Groups",
            "Exito Hr Solution Pvt Ltd."};

    String address[] = {"Bengaluru",
            "Laxmi Nagar, Delhi",
            "Bengaluru",
            "Brigade Road, Bengaluru",
            "Delhi",
            "Uttamnagar, West Delhi",
            "Dwarka,West Delhi"};

    String locality[] = {"Bengaluru, Mumbai, Thane, Chennai",
            "Hyderabad, Bengaluru ,Pune,Delhi",
            "Surat, Gurugram, Bengaluru, Chennai",
            "Bengaluru",
            "Delhi/NCR, Delhi",
            "Delhi",
            "Delhi, Chennai, Mumbai, Bengaluru"};

    String url[] = {"http://www.meerajobs.in",
            "http://www.juristzone.com",
            "http://www.excelindiahrservices.com",
            "http://www.klaxonindia.com",
            "http://www.nidhimaritime.in",
            "http://www.shrever.com",
            "http://www.exitohrs.com"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_placement_con_hr, container, false);

        recyclerView = (RecyclerView)v.findViewById(R.id.plac_con_hr_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        listItems = new ArrayList<>();

        for(int i=0;i<name.length;i++)
        {
            listItems.add(new PlacementConRecyclerItems(name[i],address[i],locality[i],url[i]));
        }
        adapter = new PlacementConAdapter(listItems,getContext());
        recyclerView.setAdapter(adapter);

        return v;
    }
}