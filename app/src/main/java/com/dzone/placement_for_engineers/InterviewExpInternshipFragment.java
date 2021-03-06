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
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class InterviewExpInternshipFragment extends Fragment {

    private RecyclerView recyclerView;
    private FloatingActionButton add;
    private interviewExpAdapter adapter;
    FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;
    private List<internshipExpRecyclerItems> listItems;
    private ProgressBar spinner;
    private LinearLayout pb;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_interview_exp_internship, container, false);
        pb = (LinearLayout)view.findViewById(R.id.linlaHeaderProgress);
        pb.setVisibility(View.VISIBLE);
        spinner=(ProgressBar)view.findViewById(R.id.progressBar);
        spinner.setVisibility(View.VISIBLE);

        recyclerView = (RecyclerView)view.findViewById(R.id.internship_exp_recycler);
        add = (FloatingActionButton)view.findViewById(R.id.add_intern);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),AddInternshipExp.class));
            }
        });

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //insert your code here
        listItems = new ArrayList<>();
        databaseReference = database.getReference("InterviewExpInternship");


        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    for(DataSnapshot dp : ds.getChildren()){
                        String name = dp.child("Name").getValue(String.class);
                        String title = dp.child("Title").getValue(String.class);
                        String desc = dp.child("Description").getValue(String.class);

                        listItems.add(new internshipExpRecyclerItems(name,title,desc));
                    }
                }


                adapter = new interviewExpAdapter(listItems,getContext());
                recyclerView.setAdapter(adapter);
                spinner.setVisibility(View.GONE);
                pb.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        databaseReference.addValueEventListener(eventListener);
        return view;
    }
}
