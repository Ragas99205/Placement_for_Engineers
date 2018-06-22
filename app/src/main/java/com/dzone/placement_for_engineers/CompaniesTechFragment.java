package com.dzone.placement_for_engineers;

import android.content.Context;
import android.net.Uri;
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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class CompaniesTechFragment extends Fragment {
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;
    ArrayList<HashMap<String, String>> techCompanyList;

    ListView lvw;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        databaseReference = database.getReference("Companies").child("Tech");
        lvw = (ListView)getView().findViewById(R.id.mylist);

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

                    HashMap<String, String> techCompany = new HashMap<>();

                    techCompany.put("Name",name);
                    techCompany.put("CTC",ctc);
                    techCompany.put("Role",role);
                    techCompany.put("Type",type);
                    techCompany.put("URL",url);
                    techCompany.put("WikiURL",wikiurl);

                    techCompanyList.add(techCompany);
                }
                ListAdapter adapter = new SimpleAdapter(getActivity(), techCompanyList,
                        R.layout.tech_list, new String[]{"name", "ctc", "role","type","url","wiki"},
                        new int[]{R.id.tech_name,R.id.tech_ctc,R.id.tech_role, R.id.tech_type,R.id.tech_url,R.id.tech_wiki});

                lvw.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        databaseReference.addListenerForSingleValueEvent(eventListener);
        return inflater.inflate(R.layout.fragment_companies_tech, container, false);
    }
}
