package com.shayekh.android.webservice;


import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_Service {
    @GET("/")
    Call<UserResponse> getUser();
}
