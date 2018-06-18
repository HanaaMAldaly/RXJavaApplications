package com.triplanner.iti.startingrxjava.MVP.Model.NetworkLayer;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hanaa on 6/15/2018.
 */

class RetrofitClient {
    private static  Retrofit ourInstance=null ;

    static Retrofit getInstance()
    {
        if(ourInstance==null) {
            ourInstance = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return ourInstance;
    }

    private RetrofitClient() {
    }
}
