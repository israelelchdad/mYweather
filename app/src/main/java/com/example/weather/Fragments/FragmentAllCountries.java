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


public class FragmentAllCountries extends Fragment implements View.OnClickListener {
    ArrayList<Country>myListAllCountry;
    View myView;
    Button asia;
    Button europe;
    Button africa;
    Button america;
    Button other;
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

    private void initButtens() {
        asia = myView.findViewById(R.id.fa_asia);
        asia.setOnClickListener(this);
        africa = myView.findViewById(R.id.fa_africa);
        africa.setOnClickListener(this);
        america = myView.findViewById(R.id.fa_america);
        america.setOnClickListener(this);
        europe = myView.findViewById(R.id.fa_europe);
        europe.setOnClickListener(this);
        other = myView.findViewById(R.id.fa_other);
        other.setOnClickListener(this);

    }

    private void initrecyrclerview(ArrayList<Country>myListCountry) {
        myRecyclerViewOfallContries = myView.findViewById(R.id.Fall_recyercleview_all);
        myLayoutManager = new LinearLayoutManager(getContext());
        myRecyclerViewOfallContries.setLayoutManager(myLayoutManager);
        myAdapterOfallCountries = new AdapterOfallCountries(myListCountry);
        myRecyclerViewOfallContries.setAdapter(myAdapterOfallCountries);

    }

    public void initListAllCountries() {
        Call<Country[]> call = RestClient.mycounryisService.getAllCountries();
        call.enqueue(new Callback<Country[]>() {
            @Override
            public void onResponse(Call<Country[]> call, Response<Country[]> response) {
                Country[] myAreyCounty= response.body();
                myListAllCountry = new ArrayList<>(Arrays.asList(myAreyCounty));
                int a = 5;
                initrecyrclerview(myListAllCountry);
            }

            @Override
            public void onFailure(Call<Country[]> call, Throwable t) {
                int b = 6;
                int c = 7;

            }
        });
    }



    public void onButtonPressed() {
        if (mListener != null) {
            mListener.onFragmentInteraction();
        }
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

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.fa_asia  :
                break;
            case R.id.fa_america  :
                break;
            case R.id.fa_africa :
                break;
            case R.id.fa_europe  :
                break;
            case R.id.fa_other :
                break;


    }}


    public interface OnFragmentInteractionListener {

        void onFragmentInteraction();
    }
}
