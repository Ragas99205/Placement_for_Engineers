package com.dzone.placement_for_engineers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class PlacementConEduFragment extends Fragment {
    private RecyclerView recyclerView;
    private PlacementConAdapter adapter;
    private List<PlacementConRecyclerItems> listItems;

    private String name[] = {"APS Placement",
            "Jurist Zone",
            "Guru Placement Division",
            "Klaxon India",
            "Talent Zone Consultant",
            "DDS Group",
            "Winterland Jobs"};

    private String address[] = {"418, Vardhman city, || Plaza, Asif Ali Road, Delhi",
            "Laxmi Nagar, Delhi",
            "Delhi",
            "Brigade Road, Bengaluru",
            "Malleshwaram, Bengaluru",
            "Gurugram",
            "Sec-67, Gurugram"};

    private String locality[] = {"Delhi",
            "Hyderabad, Bengaluru ,Pune,Delhi",
            "Bhiwani, Pune, Jaipur, Delhi",
            "Bengaluru",
            "Bengaluru, Hubli",
            "Gurugram, Haryana",
            "Gurugram"};

    private String url[] = {"http://www.apsplacement.in",
            "http://www.juristzone.com",
            "http://www.guruplacement.com",
            "http://www.klaxonindia.com",
            "http://www.talentzoneconsultant.com",
            "http://www.ddsg.in",
            "http://www.winterlandjobs.com"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_placement_con_edu, container, false);

        recyclerView = (RecyclerView)v.findViewById(R.id.plac_con_edu_recycler);
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