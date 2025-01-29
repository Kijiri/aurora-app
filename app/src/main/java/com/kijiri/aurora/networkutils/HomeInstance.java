package com.kijiri.aurora.networkutils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeInstance {
    private static Retrofit homeInstance;
    private static final String BASE_URL = "http://localhost:8080/";

    public static Retrofit initializeInstance() {
        if (homeInstance == null) {
            homeInstance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return homeInstance;
    }
}
