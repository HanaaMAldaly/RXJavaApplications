package com.triplanner.iti.startingrxjava.Day3.depencdecyinjection;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.triplanner.iti.startingrxjava.Day3.Model.DataSource;
import com.triplanner.iti.startingrxjava.Day3.entities.Post;
import com.triplanner.iti.startingrxjava.Day3.fetures.PostViewModel;
import com.triplanner.iti.startingrxjava.Day3.network.APIInterface;

import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hanaa on 6/18/2018.
 */
@Module
public class Module3 {
    Context context;
    public Module3(){

    }
    public Module3(Context context){
        this.context=context;
    }
    @Provides
    DataSource getDataSource(){
        return new DataSource();
    }
    @Provides
    @Singleton
    PostViewModel getViewModel(){
        return new PostViewModel();
    }
    @Provides
    Context getAppContext(){
        return this.context;
    }
    @Provides
    @Singleton
    Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
    @Named("hhh")
    @Provides
    Retrofit getRetrofit2(){
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
    @Provides
    APIInterface getAPIInterface(Retrofit retrofit){
        return retrofit.create(APIInterface.class);
    }
    @Provides
    Single<List<Post>> getPosts(APIInterface apiInterface){
        return  apiInterface.getPosts();
    }
    @Provides
    List<Post> getPostsList(Single<List<Post>>posts){
        return posts.subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.io())
                .blockingGet();
    }
    @Provides
    String getString(){
        return new String("kkk");
    }
}
