package com.example.weather;

import com.example.weather.Moudel.Country;
import com.example.weather.Moudel.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CounryisService {
    @GET("v2/region/{nameRegion}")
    Call<Country[]> serchContryByRegion(@Path("nameRegion") String nameRegion);
    @GET("v2")
    Call<Country[]> getAllCountries();

    @GET("weather?lat={lat}&lon={lon}&APPID=a02c2b15e0deb71fca74286cfcdb363e")
    Call<Response> getWeather(@Path("lat") double lat, @Path("lon") double lon);

    @GET("weather?lat=35&lon=139&appid=b6907d289e10d714a6e88b30761fae22")
    Call<Response> getWeather2();


}
