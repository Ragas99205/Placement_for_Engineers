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


public class CompaniesCoreFragment extends Fragment {

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;
    ArrayList<HashMap<String, String>> coreCompanyList;

    ListView lvw;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_companies_core, container, false);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        databaseReference = database.getReference("Companies").child("Core");
        lvw = (ListView)view.findViewById(R.id.core_list);
        coreCompanyList = new ArrayList<>();

        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    String name = ds.child("Name").getValue(String.class);
                    String ctc = ds.child("CTC").getValue(String.class);
                    String pref_stream = ds.child("Prefered Stream").getValue(String.class);
                    String url = ds.child("URL").getValue(String.class);
                    String wikiurl = ds.child("WikiURL").getValue(String.class);


                    HashMap<String, String> coreCompany = new HashMap<>();

                    coreCompany.put("Name",name);
                    coreCompany.put("CTC",ctc);
                    coreCompany.put("Prefered Stream",pref_stream);
                    coreCompany.put("URL",url);
                    coreCompany.put("WikiURL",wikiurl);

                    coreCompanyList.add(coreCompany);


                }
                ListAdapter adapter = new SimpleAdapter(getActivity(), coreCompanyList,
                        R.layout.core_list, new String[]{"Name", "CTC", "Prefered Stream","URL","WikiURL"},
                        new int[]{R.id.core_name,R.id.core_ctc,R.id.core_pref_stream, R.id.core_url,R.id.core_wiki});

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
