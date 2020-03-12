package com.example.weather.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.ahmadrosid.svgloader.SvgLoader;
import com.example.weather.Moudel.Country;
import com.example.weather.Moudel.Responsee;
import com.example.weather.R;
import com.example.weather.RestClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Country myCountry ;
    private ArrayList latlang;
    Double one;
    Double tow;
    TextView nameCountry;
    TextView weathercountry;
    ImageView iconweather;
    ImageView flagCountry;
    Double kelvin = 273.15;
    Double myweather;
    String iconUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        latlang= this.getIntent().getParcelableArrayListExtra(ActivityAllCountries.KEY);
        myCountry = this.getIntent().getParcelableExtra(ActivityAllCountries.KEYCOUNTRY);

        one = (Double) latlang.get(0);
        tow = (Double) latlang.get(1);



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
        mMap.setMaxZoomPreference(10.0f);
        mMap.setMinZoomPreference(7.0f);
        // Add a marker in Sydney and move the camera

        LatLng mylatlang = new LatLng(one, tow);
        initWheather(mylatlang);
        mMap.addMarker(new MarkerOptions().position(mylatlang));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(mylatlang));

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                mMap.addMarker(new MarkerOptions().position(latLng).title("Marker in "+ latLng));
                initWheather(latLng);
            }




        });
    }

    private void initWheather(LatLng latLng) {

        Call<Responsee> call = RestClient.mycounryisService2.getWeather(latLng.latitude,latLng.longitude);
        call.enqueue(new Callback<Responsee>() {
            @Override
            public void onResponse(Call<Responsee> call, retrofit2.Response<Responsee> response) {
                Responsee a = response.body();
                myweather = a.getMain().getTemp()-kelvin;
                iconUrl ="http://openweathermap.org/img/w/" +a.getWeather().get(0).getIcon() + ".png";
                Toast.makeText(getBaseContext(), String.valueOf( "WEATHER IS COUNTRY = "+myweather),
                        Toast.LENGTH_LONG).show();
                initDataOfConrty();




                int m = 7;

            }

            @Override
            public void onFailure(Call<Responsee> call, Throwable t) {
                int c = 6;
                int n = 6;

            }
        });

    }

    private void initDataOfConrty() {
        nameCountry = findViewById(R.id.amaps_namecountry);
        weathercountry = findViewById(R.id.amaps_weathercountry);
        iconweather = findViewById(R.id.amaps_iconeather);
        flagCountry = findViewById(R.id.amaps_imgcountry);
        nameCountry.setText(myCountry.getName()+" of regin "+ myCountry.getRegion());
        weathercountry.setText("WEATHER : "+myweather+" celsus");
        SvgLoader.pluck()
                .with((Activity) this)
                .load(myCountry.getFlag(), flagCountry);
//        SvgLoader.pluck()
//                .with((Activity) this)
//                .load(iconUrl, iconweather);

        Picasso.get().load(iconUrl).into(iconweather);
        
    }


}
