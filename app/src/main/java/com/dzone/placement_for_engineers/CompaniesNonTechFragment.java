package com.dzone.placement_for_engineers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
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


public class CompaniesNonTechFragment extends Fragment {

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;
    ArrayList<HashMap<String, String>> nontechCompanyList;

    ListView lvw;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_companies_non_tech, container, false);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        databaseReference = database.getReference("Companies").child("NonTech");
        lvw = (ListView)view.findViewById(R.id.nontech_list);
        nontechCompanyList = new ArrayList<>();

        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    String name = ds.child("Name").getValue(String.class);
                    String ctc = ds.child("CTC").getValue(String.class);
                    String type = ds.child("Type").getValue(String.class);
                    String url = ds.child("URL").getValue(String.class);
                    String wikiurl = ds.child("WikiURL").getValue(String.class);



                    HashMap<String, String> nontechCompany = new HashMap<>();

                    nontechCompany.put("Name",name);
                    nontechCompany.put("CTC",ctc);
                    nontechCompany.put("Type",type);
                    nontechCompany.put("URL",url);
                    nontechCompany.put("WikiURL",wikiurl);

                    nontechCompanyList.add(nontechCompany);


                }

                ListAdapter adapter = new SimpleAdapter(getActivity(), nontechCompanyList,
                        R.layout.nontech_list, new String[]{"Name", "CTC", "Type","URL","WikiURL"},
                        new int[]{R.id.nontech_name,R.id.nontech_ctc, R.id.nontech_type,R.id.nontech_url,R.id.nontech_wiki});

                lvw.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        databaseReference.addValueEventListener(eventListener);

        return view;
    }
}