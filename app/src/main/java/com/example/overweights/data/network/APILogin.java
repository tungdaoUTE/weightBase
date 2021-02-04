package com.example.overweights.data.network;

import com.example.overweights.data.model.data.User;
import com.example.overweights.data.model.request.LoginRequest;
import com.example.overweights.data.model.response.TokenResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APILogin {
    @POST("api/authenticate")
    Call<TokenResponse> authentication(@Body LoginRequest loginRequest);

    @GET("api/account")
    Call<User> account();
}
