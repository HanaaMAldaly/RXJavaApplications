package com.triplanner.iti.startingrxjava.Day3.network;

import com.triplanner.iti.startingrxjava.Day3.entities.Post;

import java.util.List;


import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;


/**
 * Created by Hanaa on 5/21/2018.
 */

public interface APIInterface {
    @GET("posts")
    Single<List<Post>> getPosts();
}
