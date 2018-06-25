package com.dzone.placement_for_engineers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CompaniesTechFragment extends Fragment {
    private RecyclerView recyclerView;
    private techCompanyAdapter adapter;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;
    private List<techCompanyRecyclerItems> listItems;

    ListView lvw;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_companies_tech, container, false);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        databaseReference = database.getReference("Companies").child("Tech");
        lvw = (ListView)view.findViewById(R.id.tech_list);
        listItems = new ArrayList<>();

        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    String name = ds.child("Name").getValue(String.class);
                    String ctc = ds.child("CTC").getValue(String.class);
                    String role = ds.child("Role").getValue(String.class);
                    String type = ds.child("Type").getValue(String.class);
                    String url = ds.child("URL").getValue(String.class);
                    String wikiurl = ds.child("WikiURL").getValue(String.class);

                    listItems.add(new techCompanyRecyclerItems(name,ctc,role,type,url,wikiurl));
                }
                adapter = new techCompanyAdapter(listItems,getContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        databaseReference.addValueEventListener(eventListener);

        return view;
    }
}
