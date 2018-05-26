package com.triplanner.iti.startingrxjava.Day3.Model;

import com.triplanner.iti.startingrxjava.Day3.entities.Post;
import com.triplanner.iti.startingrxjava.Day3.network.APIInterface;
import com.triplanner.iti.startingrxjava.Day3.network.RetrofitClient;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;

/**
 * Created by Hanaa on 5/21/2018.
 */

public class DataSource {
    public Single<List<Post>> getData(){
        Retrofit retrofit= RetrofitClient.getInstance();
        APIInterface apiInterface=retrofit.create(APIInterface.class);
        return apiInterface.getPosts();
    }
}
