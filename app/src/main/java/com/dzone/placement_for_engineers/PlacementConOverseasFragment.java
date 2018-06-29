package com.dzone.placement_for_engineers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PlacementConOverseasFragment extends Fragment {
    TextView t6,t12,t18,t24,t30,t36,t42;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_placement_con_overseas, container, false);

        t6=(TextView)v.findViewById(R.id.tv6);
        t12=(TextView)v.findViewById(R.id.tv12);
        t18=(TextView)v.findViewById(R.id.tv18);
        t24=(TextView)v.findViewById(R.id.tv24);
        t30=(TextView)v.findViewById(R.id.tv30);
        t36=(TextView)v.findViewById(R.id.tv36);
        t42=(TextView)v.findViewById(R.id.tv42);


        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.dishihrsolutions.in"); // missing 'http://' will cause crashed
                Intent i3 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i3);
            }
        });
        t12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.placementmadad.com"); // missing 'http://' will cause crashed
                Intent i4 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i4);
            }
        });
        t18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.nishulkjob.com"); // missing 'http://' will cause crashed
                Intent i5 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i5);
            }
        });
        t24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.careerpointconsultancy.co.in"); // missing 'http://' will cause crashed
                Intent i6 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i6);
            }
        });
        t30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.medidantjobs.co.in"); // missing 'http://' will cause crashed
                Intent i7 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i7);
            }
        });
        t36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.riyazconsultancy.co.in"); // missing 'http://' will cause crashed
                Intent i8 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i8);
            }
        });
        t42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.zamirenterprises.com"); // missing 'http://' will cause crashed
                Intent i8 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i8);
            }
        });

        return v;
    }
}