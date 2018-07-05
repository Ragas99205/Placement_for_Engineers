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


public class PlacementConOverseasFragment extends Fragment {
    private RecyclerView recyclerView;
    private PlacementConAdapter adapter;
    private List<PlacementConRecyclerItems> listItems;

    String name[] = {"Dishi HR Solutions",
            "Placement Madad",
            "Nishulk Job",
            "Career Point Consultancy",
            "Medident Jobs",
            "Riyaz Consultancy Services",
            "Zamir Enterprises"};

    String address[] = {"Delhi",
            "Delhi",
            "Delhi",
            "Hyderabad",
            "Banjara Hills, Road 10, Hyderabad",
            "Murbad Road, Kalyan West , Mumubai",
            "Khar west, Mumbai"};

    String locality[] = {"Bengaluru, Mumbai, Pune, Kolkata, Chennai",
            "Gurugram, Faridabad ,Noida, Delhi, Ghaziabad",
            "Delhi/NCR, Delhi",
            "Hyderabad, Bangaluru, Mumbai, Khordha",
            "Hyderabad",
            "Gurugram, Delhi, Mumbai",
            "Mumbai"};

    String url[] = {"http://www.dishihrsolutions.in",
            "http://www.placementmadad.com",
            "http://www.nishulkjob.com",
            "http://www.careerpointconsultancy.co.in",
            "http://www.medidantjobs.co.in",
            "http://www.riyazconsultancy.co.in",
            "http://www.zamirenterprises.com"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_placement_con_overseas, container, false);

        recyclerView = (RecyclerView)v.findViewById(R.id.plac_con_overseas_recycler);
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