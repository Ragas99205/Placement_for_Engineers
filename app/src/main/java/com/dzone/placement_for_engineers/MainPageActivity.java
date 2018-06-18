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
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;

public class MainPageActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    CompaniesTechFragment ctf = (CompaniesTechFragment)getSupportFragmentManager().findFragmentByTag("Companies_Tech");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //handle navigation drawer item click
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


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
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            findViewById(R.id.scrollview).setVisibility(View.VISIBLE);
        }

    }

    public void companies_tech(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CompaniesTechFragment()).commit();
        findViewById(R.id.scrollview).setVisibility(View.GONE);
    }

    public void companies_non_tech(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CompaniesTechFragment()).commit();
        findViewById(R.id.scrollview).setVisibility(View.GONE);
    }

    public void companies_core(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CompaniesTechFragment()).commit();
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

