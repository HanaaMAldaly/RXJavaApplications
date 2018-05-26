package com.triplanner.iti.startingrxjava.Day4;

import com.triplanner.iti.startingrxjava.Day4.NetworkLayer.RetrofitClient;
import com.triplanner.iti.startingrxjava.Day4.NetworkLayer.RetrofitInterface;
import com.triplanner.iti.startingrxjava.Day4.entities.Photo;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;

/**
 * Created by Hanaa on 5/25/2018.
 */

public class DataSource {
    public static Single<List<Photo>>getData()
    {
        Retrofit retrofit = RetrofitClient.getINSTANCE();
        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);
        return retrofitInterface.getPhotos();
    }
}
