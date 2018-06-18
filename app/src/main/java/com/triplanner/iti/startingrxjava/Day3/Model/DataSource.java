package com.triplanner.iti.startingrxjava.Day3.Model;

import com.triplanner.iti.startingrxjava.Day3.depencdecyinjection.DaggerMyComponent3;
import com.triplanner.iti.startingrxjava.Day3.entities.Post;
import com.triplanner.iti.startingrxjava.Day3.network.APIInterface;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Retrofit;

/**
 * Created by Hanaa on 5/21/2018.
 */

public class DataSource {

    @Inject
    Single<List<Post>> posts;
    @Inject
    public DataSource() {
        DaggerMyComponent3.builder().build().inject(this);
    }

    public Single<List<Post>> getData(){
        return posts;
    }
}