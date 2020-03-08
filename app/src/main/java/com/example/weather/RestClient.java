package com.example.weather;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    private static final String BASE_URL = "https://restcountries.eu/rest/";
    private static final String BASE_URL2 = "https://samples.openweathermap.org/data/2.5/";
    private static Retrofit myRetrofit = new  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static Retrofit myRetrofit2 = new  Retrofit.Builder()
            .baseUrl(BASE_URL2)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
       public static  CounryisService mycounryisService = myRetrofit.create(CounryisService.class);
       public static CounryisService mycounryisService2 = myRetrofit2.create(CounryisService.class);
}
