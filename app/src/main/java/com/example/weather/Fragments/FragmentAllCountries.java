package com.example.weather.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.Adapters.AdapterOfallCountries;
import com.example.weather.Moudel.Country;
import com.example.weather.R;
import com.example.weather.RestClient;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentAllCountries extends Fragment implements View.OnClickListener,AdapterOfallCountries.OnClicMoveCountry {
    ArrayList<Country>myListAllCountry;
    ArrayList<Country>myListAllCountryies = new ArrayList<>();
    ArrayList<Country>myListCountryByRegin;
    ArrayList<Country> myListContrie;
    private String myRegion = "";
    View myView;
    Button asia;
    Button europe;
    Button africa;
    Button america;
    Button allCountry;
    Button Ocania;
    private RecyclerView myRecyclerViewOfallContries;
    private RecyclerView.LayoutManager myLayoutManager;
    private AdapterOfallCountries myAdapterOfallCountries;

    private OnFragmentInteractionListener mListener;

    public FragmentAllCountries() {

    }


    public static FragmentAllCountries newInstance() {
        FragmentAllCountries fragment = new FragmentAllCountries();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myView =inflater.inflate(R.layout.fragment_fragment_all_countries, container, false);
        initListAllCountries();
        initButtens();

        return myView;
    }

    public void initListAllCountries() {
        Call<Country[]> call = RestClient.mycounryisService.getAllCountries();
        call.enqueue(new Callback<Country[]>() {
            @Override
            public void onResponse(Call<Country[]> call, Response<Country[]> response) {
                Country[] myAreyCounty= response.body();
                myListAllCountry = new ArrayList<>(Arrays.asList(myAreyCounty));
                myListAllCountryies.addAll(myListAllCountry);
                initrecyrclerview(myListAllCountry);
            }

            @Override
            public void onFailure(Call<Country[]> call, Throwable t) {

            }
        });
    }

    private void initButtens() {
        asia = myView.findViewById(R.id.fa_asia);
        asia.setOnClickListener(this);
        africa = myView.findViewById(R.id.fa_africa);
        africa.setOnClickListener(this);
        america = myView.findViewById(R.id.fa_america);
        america.setOnClickListener(this);
        europe = myView.findViewById(R.id.fa_europe);
        europe.setOnClickListener(this);
        allCountry = myView.findViewById(R.id.fa_allCountry);
        allCountry.setOnClickListener(this);
        Ocania = myView.findViewById(R.id.fa_Ocania);
        Ocania.setOnClickListener(this);

    }

    private void initrecyrclerview(ArrayList<Country>myListCountry) {
        myRecyclerViewOfallContries = myView.findViewById(R.id.Fall_recyercleview_all);
        myLayoutManager = new LinearLayoutManager(getContext());
        myRecyclerViewOfallContries.setLayoutManager(myLayoutManager);
        myAdapterOfallCountries = new AdapterOfallCountries(myListCountry, getContext(),this);
        myRecyclerViewOfallContries.setAdapter(myAdapterOfallCountries);

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    public void onButtonPressed() {
        if (mListener != null) {
           mListener.onFragmentLisitinre();
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.fa_asia  :
                myRegion = "Asia";
                //initListCountriesByRegin("Asia");
                initListCountriesByReginByAllContries(myRegion);
                break;
            case R.id.fa_america  :
                myRegion = "Americas";
                //initListCountriesByRegin("Americas");
                initListCountriesByReginByAllContries(myRegion);
                break;
            case R.id.fa_africa :
                myRegion = "Africa";
                //initListCountriesByRegin("Africa");
                initListCountriesByReginByAllContries(myRegion);
                break;
            case R.id.fa_europe  :
                myRegion = "Europe";
                //initListCountriesByRegin("Europe");
                initListCountriesByReginByAllContries(myRegion);
                break;
            case R.id.fa_Ocania  :
                myRegion = "Oceania";
                //initListCountriesByRegin("Oceania");
                initListCountriesByReginByAllContries(myRegion);
                break;
            case R.id.fa_allCountry :
                myRegion = "";
                initListCountriesByReginByAllContries(myRegion);
                break;


    }}

    private void initListCountriesByReginByAllContries(String regin) {
         myListContrie = new ArrayList<>();
        for (Country myContry:myListAllCountryies) {
          if(myContry.getRegion().contains(regin)){
              myListContrie.add(myContry);

        }
        }

        //initrecyrclerview(myListContrie);
        setData();
    }

    private void setData() {
        myListAllCountry.clear();
        myListAllCountry.addAll(myListContrie);
        myAdapterOfallCountries.notifyDataSetChanged();
    }

    private void initListCountriesByRegin(String region) {
        Call<Country[]> call = RestClient.mycounryisService.serchContryByRegion(region);
        call.enqueue(new Callback<Country[]>() {
            @Override
            public void onResponse(Call<Country[]> call, Response<Country[]> response) {
                Country[] myAreyCounty= response.body();
                myListCountryByRegin = new ArrayList<>(Arrays.asList(myAreyCounty));
                initrecyrclerview(myListCountryByRegin);

            }

            @Override
            public void onFailure(Call<Country[]> call, Throwable t) {


            }
        });


    }

    @Override
    public void  MoveContry(Country myCountry) {

        mListener.moveCountryToActivity(myCountry);

    }


    public interface OnFragmentInteractionListener {
        void onFragmentLisitinre();
        void moveCountryToActivity(Country myCountry);
    }
}
