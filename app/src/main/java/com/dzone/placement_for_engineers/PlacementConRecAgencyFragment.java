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


public class PlacementConRecAgencyFragment extends Fragment {
    private RecyclerView recyclerView;
    private PlacementConAdapter adapter;
    private List<PlacementConRecyclerItems> listItems;

    String name[] = {"Perfect Solution Group",
            "Placement Madad",
            "Sandeep Placement",
            "Career Point Consultancy",
            "Imperial Training and Consulting",
            "IdeaSpot Consultant",
            "Ignite Enterprise"};

    String address[] = {"Delhi",
            "Delhi",
            "Mandawali, Delhi",
            "Hyderabad",
            "Hyderabad",
            "Haldia",
            "Garia Station, Kolkata"};

    String locality[] = {"Rohtak, Delhi",
            "Gurugram, Faridabad ,Noida, Delhi, Ghaziabad",
            "Delhi",
            "Hyderabad, Bangaluru, Mumbai, Khordha",
            "Hyderabad, Delhi, Bengaluru, Pune",
            "Kharagpur, Haldia, Kolkata, Durgapur",
            "Kolkata"};

    String url[] = {"http://www.perfectsolutiongroup.co.in",
            "http://www.placementmadad.com",
            "http://www.sandeepplacementindia.in",
            "http://www.careerpointconsultancy.co.in",
            "http://www.itcimperial.in",
            "http://www.ideaspotconsultant.in",
            "http://www.ignitehr.in"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        
        View v = inflater.inflate(R.layout.fragment_placement_con_rec_agency, container, false);

        recyclerView = (RecyclerView)v.findViewById(R.id.plac_con_rec_agency_recycler);
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