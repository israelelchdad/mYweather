package com.example.weather;

import com.example.weather.Moudel.Country;
import com.example.weather.Moudel.Responsee;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CounryisService {
    @GET("v2/region/{nameRegion}")
    Call<Country[]> serchContryByRegion(@Path("nameRegion") String nameRegion);
    @GET("v2")
    Call<Country[]> getAllCountries();

    @GET("weather?APPID=a02c2b15e0deb71fca74286cfcdb363e")
    Call<Responsee> getWeather(@Query("lat") double lat, @Query("lon") double lon);

    @GET("weather?lat=35&lon=139&APPID=a02c2b15e0deb71fca74286cfcdb363e")
    Call<Responsee> getWeather2();


}
