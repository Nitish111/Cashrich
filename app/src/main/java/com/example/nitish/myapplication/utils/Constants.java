package com.example.nitish.myapplication.utils;

import android.content.Context;
import android.net.ConnectivityManager;


public class Constants {
    public static String BASE_URL = "https://newsapi.org/";
    public static String API_KEY = "ADD_YOUR_API_KEY_HERE";
    public static String COUNTRY = "us";
    public static boolean isInternetAvailable(Context context) {

        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();

    }
}
