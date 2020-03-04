package com.example.weather.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weather.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moveToActivityShowAllCountries();

    }

    private void moveToActivityShowAllCountries() {
        Intent intent = new Intent(this, ActivityAllCountries.class);
        startActivity(intent);

    }


}
