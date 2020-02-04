package com.shayekh.android.webservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api_Response {
    private static Retrofit retrofit;
    private static String BASE_URL = "https://api.randomuser.me";
    public static Retrofit getUser() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}
