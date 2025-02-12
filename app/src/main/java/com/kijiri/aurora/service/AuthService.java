package com.kijiri.aurora.service;
import com.kijiri.aurora.ui.authentication.AuthenticationResponse;
import com.kijiri.aurora.ui.authentication.LoginUser;
import com.kijiri.aurora.ui.authentication.RefreshToken;
import com.kijiri.aurora.ui.authentication.RegisterUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface AuthService {
    @POST("api/v1/auth/register")
    Call<String> register(@Body RegisterUser registerUser);

    @POST("api/v1/auth/authenticate")
    Call<AuthenticationResponse> login(@Body LoginUser registerUser);

    @POST("api/v1/auth/refresh")
    Call<RefreshToken> refreshToken(@Body RefreshToken registerUser);

}
