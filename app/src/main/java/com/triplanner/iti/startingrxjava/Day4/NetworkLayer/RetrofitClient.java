package com.triplanner.iti.startingrxjava.Day4.NetworkLayer;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hanaa on 5/25/2018.
 */

public class RetrofitClient {
    private static Retrofit INSTANCE=null;
    private RetrofitClient(){}
    private final static  String baseURL="https://jsonplaceholder.typicode.com/";
    public static Retrofit getINSTANCE(){
        if (INSTANCE==null)
        {
            INSTANCE=new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

        }
            return INSTANCE;
    }

}
