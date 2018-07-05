package com.dzone.placement_for_engineers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    TextView companies_tech;
    Fragment CompaniesTech;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);

//        companies_tech = (TextView)v.findViewById(R.id.companies_tech);
//        companies_tech.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                CompaniesTech.getFragmentManager().beginTransaction().replace(R.id.fragment_container, new CompaniesTechFragment()).commit();
////                Intent i = new Intent(getActivity(), CompaniesTechFragment.class);
////                startActivity(i);
//            }
//        });

        return v;
    }

//    public void companies(View v){
//        CompaniesTech.getFragmentManager().beginTransaction().replace(R.id.fragment_container, new CompaniesTechFragment()).commit();
//    }
}

