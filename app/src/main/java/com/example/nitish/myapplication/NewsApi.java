package com.example.nitish.myapplication;

import com.example.nitish.myapplication.modal.NewsModal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("v2/top-headlines")
    Call<NewsModal> getNews(@Query("country") String country, @Query("apiKey") String apiKey, @Query("page") int page, @Query("pageSize") int pageSize);

}
