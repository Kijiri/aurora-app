package com.kijiri.aurora.ui.home;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HomeService {
    @GET
    Call<List<TempResponse>> fetchPost();
}
