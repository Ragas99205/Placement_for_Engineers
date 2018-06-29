package com.dzone.placement_for_engineers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class InterviewExpJobFragment extends Fragment {

    private RecyclerView recyclerView;
    private FloatingActionButton add;
    private jobExpAdapter adapter;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;
    private List<jobExpRecyclerItems> listItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_interview_exp_job, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.job_exp_recycler);
        add = (FloatingActionButton)view.findViewById(R.id.add_job);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),AddJobExp.class));
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //insert your code here
        listItems = new ArrayList<>();
        databaseReference = database.getReference("InterviewExpJob");


        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    String name = ds.child("Name").getValue(String.class);
                    String title = ds.child("Title").getValue(String.class);
                    String desc = ds.child("Description").getValue(String.class);

                    listItems.add(new jobExpRecyclerItems(name,title,desc));
                }
                adapter = new jobExpAdapter(listItems,getContext());
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