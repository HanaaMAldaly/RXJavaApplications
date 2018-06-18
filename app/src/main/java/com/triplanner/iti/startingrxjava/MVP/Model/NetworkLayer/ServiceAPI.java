package com.triplanner.iti.startingrxjava.MVP.Model.NetworkLayer;

import com.triplanner.iti.startingrxjava.Day4.entities.Photo;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by Hanaa on 6/15/2018.
 */

public interface ServiceAPI {
    @GET("photos")
    Single<List<Photo>> getPhotos();
}
