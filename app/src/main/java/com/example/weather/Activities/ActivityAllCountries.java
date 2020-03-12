package com.example.weather.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weather.Fragments.FragmentAllCountries;
import com.example.weather.Moudel.Country;
import com.example.weather.R;

import java.util.ArrayList;

public class ActivityAllCountries extends AppCompatActivity implements FragmentAllCountries.OnFragmentInteractionListener {
    public static final String KEY= "KEY";
    public static final String KEYCOUNTRY= "KEYCOUNTRY";


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
    public void moveCountryToActivity(Country myCountry) {
        String name = myCountry.getName();
        Double v = myCountry.getLatlng().get(0);
        Double ve = myCountry.getLatlng().get(1);
        int a = 5;
        Intent resultIntent = new Intent(this, MapsActivity.class);
        ArrayList latLang= (ArrayList) myCountry.getLatlng();
        resultIntent.putParcelableArrayListExtra(KEY,  latLang);
        resultIntent.putExtra(KEYCOUNTRY,myCountry);
        startActivity(resultIntent);


    }
    @Override
    public void onFragmentLisitinre() {

    }
}
