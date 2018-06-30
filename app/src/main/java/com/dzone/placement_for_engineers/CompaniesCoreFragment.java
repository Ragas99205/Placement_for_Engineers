package com.dzone.placement_for_engineers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
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


public class CompaniesCoreFragment extends Fragment {

    private RecyclerView recyclerView;
    private coreCompanyAdapter adapter;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;
    private List<coreCompanyRecyclerItems> listItems;
    private ProgressBar spinner;
    private LinearLayout pb;

    ListView lvw;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_companies_core, container, false);

        pb = (LinearLayout)view.findViewById(R.id.linlaHeaderProgress);
        pb.setVisibility(View.VISIBLE);
        spinner=(ProgressBar)view.findViewById(R.id.progressBar);
        spinner.setVisibility(View.VISIBLE);
        recyclerView = (RecyclerView)view.findViewById(R.id.core_list_recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        databaseReference = database.getReference("Companies").child("Core");
        listItems = new ArrayList<>();

        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    String name = ds.child("Name").getValue(String.class);
                    String ctc = ds.child("CTC").getValue(String.class);
                    String pref_stream = ds.child("Prefered Stream").getValue(String.class);
                    String url = ds.child("URL").getValue(String.class);
                    String wikiurl = ds.child("WikiURL").getValue(String.class);

                    listItems.add(new coreCompanyRecyclerItems(name,ctc,pref_stream,url,wikiurl));
                }
                adapter = new coreCompanyAdapter(listItems,getContext());
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
