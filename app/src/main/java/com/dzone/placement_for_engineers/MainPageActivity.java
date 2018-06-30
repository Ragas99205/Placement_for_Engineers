package com.dzone.placement_for_engineers;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainPageActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FirebaseAuth mAuth;
    private DrawerLayout drawer;
    FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseName;
    CompaniesTechFragment ctf = (CompaniesTechFragment)getSupportFragmentManager().findFragmentByTag("Companies_Tech");
    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.
    private long mBackPressed;

    @Override
    public void onBackPressed()
    {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
        {
            super.onBackPressed();
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory( Intent.CATEGORY_HOME );
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
        }
        else { Toast.makeText(getBaseContext(), "Tap back button in order to exit", Toast.LENGTH_SHORT).show(); }

        mBackPressed = System.currentTimeMillis();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() == null){
                    startActivity(new Intent(MainPageActivity.this,LoginActivity.class));
                }
            }
        };

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //handle navigation drawer item click
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View header = navigationView.getHeaderView(0);


        final TextView nav_name = (TextView)header.findViewById(R.id.nav_name);
        TextView nav_email = (TextView)header.findViewById(R.id.nav_email);
        nav_email.setText(user.getEmail());
        nav_name.setText(user.getDisplayName());

        if((nav_name.getText().toString()).equals("")){
            try{
                databaseName = database.getReference("Users").child(user.getUid());

                ValueEventListener eventListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String name = dataSnapshot.child("name").getValue(String.class);
                        Log.d("TAG","Name is: " + name);
                        nav_name.setText(name);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                };
                databaseName.addListenerForSingleValueEvent(eventListener);

            }catch(Exception e){
                Toast.makeText(MainPageActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }






    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.companies_tech:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CompaniesTechFragment(), "Companies_Tech").commit();
                findViewById(R.id.scrollview).setVisibility(View.GONE);
                break;

            case R.id.companies_nontech:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CompaniesNonTechFragment()).commit();
                findViewById(R.id.scrollview).setVisibility(View.GONE);
                break;

            case R.id.companies_core:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CompaniesCoreFragment()).commit();
                findViewById(R.id.scrollview).setVisibility(View.GONE);
                break;

            case R.id.interview_exp_internship:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new InterviewExpInternshipFragment()).commit();
                findViewById(R.id.scrollview).setVisibility(View.GONE);
                break;

            case R.id.interview_exp_job:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new InterviewExpJobFragment()).commit();
                findViewById(R.id.scrollview).setVisibility(View.GONE);
                break;

            case R.id.hiring_process_tech:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HiringProcTechFragment()).commit();
                findViewById(R.id.scrollview).setVisibility(View.GONE);
                break;

            case R.id.hiring_process_nontech:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HiringProcNonTechFragment()).commit();
                findViewById(R.id.scrollview).setVisibility(View.GONE);
                break;

            case R.id.hiring_process_core:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HiringProcCoreFragment()).commit();
                findViewById(R.id.scrollview).setVisibility(View.GONE);
                break;

            case R.id.placement_consultant_hr:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PlacementConHRFragment()).commit();
                findViewById(R.id.scrollview).setVisibility(View.GONE);
                break;

            case R.id.placement_consultant_rec:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PlacementConRecAgencyFragment()).commit();
                findViewById(R.id.scrollview).setVisibility(View.GONE);
                break;

            case R.id.placement_consultant_overseas:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PlacementConOverseasFragment()).commit();
                findViewById(R.id.scrollview).setVisibility(View.GONE);
                break;

            case R.id.placement_consultant_edu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PlacementConEduFragment()).commit();
                findViewById(R.id.scrollview).setVisibility(View.GONE);
                break;

            case R.id.logout:
                mAuth.signOut();
                Toast.makeText(MainPageActivity.this,"Successfully Logged Out",Toast.LENGTH_SHORT).show();
                findViewById(R.id.scrollview).setVisibility(View.GONE);
                break;

            case R.id.share:
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                String subject = "Download Placement for Engineers app";
                String message = "Playstore link"; // replace with playstore link
                share.putExtra(Intent.EXTRA_SUBJECT, subject);
                share.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(Intent.createChooser(share, "Share via"));
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    @Override
//    public void onBackPressed() {
//        if (drawer.isDrawerOpen(GravityCompat.START)){
//            drawer.closeDrawer(GravityCompat.START);
//        }
//        else {
//            findViewById(R.id.scrollview).setVisibility(View.VISIBLE);
//        }
//
//    }

    public void companies_tech(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CompaniesTechFragment()).commit();
        findViewById(R.id.scrollview).setVisibility(View.GONE);
    }

    public void companies_non_tech(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CompaniesNonTechFragment()).commit();
        findViewById(R.id.scrollview).setVisibility(View.GONE);
    }

    public void companies_core(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CompaniesCoreFragment()).commit();
        findViewById(R.id.scrollview).setVisibility(View.GONE);
    }

    public void interview_exp_internship(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new InterviewExpInternshipFragment()).commit();
        findViewById(R.id.scrollview).setVisibility(View.GONE);
    }

    public void interview_exp_job(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new InterviewExpJobFragment()).commit();
        findViewById(R.id.scrollview).setVisibility(View.GONE);
    }

    public void hiring_proc_tech(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HiringProcTechFragment()).commit();
        findViewById(R.id.scrollview).setVisibility(View.GONE);
    }

    public void hiring_proc_non_tech(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HiringProcNonTechFragment()).commit();
        findViewById(R.id.scrollview).setVisibility(View.GONE);
    }

    public void hiring_proc_core(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HiringProcCoreFragment()).commit();
        findViewById(R.id.scrollview).setVisibility(View.GONE);
    }

    public void placement_con_hr(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PlacementConHRFragment()).commit();
        findViewById(R.id.scrollview).setVisibility(View.GONE);
    }

    public void placement_con_rec_agency(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PlacementConRecAgencyFragment()).commit();
        findViewById(R.id.scrollview).setVisibility(View.GONE);
    }

    public void placement_con_overseas(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PlacementConOverseasFragment()).commit();
        findViewById(R.id.scrollview).setVisibility(View.GONE);
    }

    public void placement_con_edu_con(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PlacementConEduFragment()).commit();
        findViewById(R.id.scrollview).setVisibility(View.GONE);
    }

    //Add playstore link
    public void share(View view) {
    }
}

