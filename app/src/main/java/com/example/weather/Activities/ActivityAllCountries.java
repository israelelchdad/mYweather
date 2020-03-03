package com.example.weather.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.weather.Fragments.FragmentAllCountries;
import com.example.weather.R;

public class ActivityAllCountries extends AppCompatActivity implements FragmentAllCountries.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_countries);
        initFragmentAllCountries();


    }

    private void initFragmentAllCountries() {
        FragmentAllCountries fragmentShoeAllCountries = FragmentAllCountries.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.ac_showall_FrameLayout,fragmentShoeAllCountries).commit();
    }

    @Override
    public void onFragmentInteraction() {

    }
}
