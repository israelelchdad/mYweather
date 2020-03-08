package com.example.weather.Activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.example.weather.Moudel.Country;
import com.example.weather.Moudel.Response;
import com.example.weather.R;
import com.example.weather.RestClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Country myCountry ;
    private ArrayList latlang;
    Double one;
    Double tow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        latlang= this.getIntent().getParcelableArrayListExtra(ActivityAllCountries.KEY);
        one = (Double) latlang.get(0);
        tow = (Double) latlang.get(1);
        int a = 5;



    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(one, tow);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                mMap.addMarker(new MarkerOptions().position(latLng).title("Marker in "+ latLng));

                Toast.makeText(getBaseContext(), String.valueOf(latLng.latitude+" "+latLng.longitude),
                        Toast.LENGTH_LONG).show();
               initWheather(latLng);
            }




        });
    }

    private void initWheather(LatLng latLng) {

        Call<Response> call = RestClient.mycounryisService2.getWeather2();
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                Response a = response.body();
                a.getMain().getTemp();
                int b = 5;

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                int c = 6;
                int n = 6;

            }
        });

    }
}
