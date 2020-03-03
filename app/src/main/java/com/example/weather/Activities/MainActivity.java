package com.example.weather.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weather.Moudel.Country;
import com.example.weather.R;
import com.example.weather.RestClient;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<Country>myListCountry;
    private String myRegion = "europe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListCountries(myRegion);
        moveToActivityShowAllCountries();



    }

    private void moveToActivityShowAllCountries() {
        Intent intent = new Intent(this, ActivityAllCountries.class);
        startActivity(intent);

    }

    private void initListCountries(String region) {
        Call<Country[]> call = RestClient.mycounryisService.serchContryByRegion(region);
        call.enqueue(new Callback<Country[]>() {
            @Override
            public void onResponse(Call<Country[]> call, Response<Country[]> response) {
                Country[] myAreyCounty= response.body();
                myListCountry = new ArrayList<>(Arrays.asList(myAreyCounty));
                int a = 5;
            }

            @Override
            public void onFailure(Call<Country[]> call, Throwable t) {
                int b = 6;
                int c = 7;

            }
        });


    }
}
