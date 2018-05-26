package com.triplanner.iti.startingrxjava.Day4.NetworkLayer;

import com.triplanner.iti.startingrxjava.Day4.entities.Photo;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by Hanaa on 5/25/2018.
 */

public interface RetrofitInterface {
    @GET("photos")
    Single<List<Photo>> getPhotos();
}
