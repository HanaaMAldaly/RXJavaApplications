package com.triplanner.iti.startingrxjava.Day3.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hanaa on 5/21/2018.
 */

public class RetrofitClient {
    private static  Retrofit ourInstance ;

    public static Retrofit getInstance() {
        if (ourInstance==null){
            ourInstance=new Retrofit.Builder()
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
