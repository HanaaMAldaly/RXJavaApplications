package com.triplanner.iti.startingrxjava.MVP.Model;

import com.triplanner.iti.startingrxjava.Day4.NetworkLayer.RetrofitClient;
import com.triplanner.iti.startingrxjava.Day4.entities.Photo;
import com.triplanner.iti.startingrxjava.MVP.Model.NetworkLayer.ServiceAPI;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Hanaa on 6/15/2018.
 */

public class DataReprositery {
    public Single<List<Photo>> getPhoto(){
        Retrofit retrofit= RetrofitClient.getINSTANCE();
        ServiceAPI serviceAPI=retrofit.create(ServiceAPI.class);
        return  serviceAPI.getPhotos()
                            .subscribeOn(Schedulers.io());
    }
}
