package com.triplanner.iti.startingrxjava.Day3.fetures;

import android.arch.lifecycle.ViewModel;

import com.triplanner.iti.startingrxjava.Day3.Model.DataSource;
import com.triplanner.iti.startingrxjava.Day3.MyApplication;
import com.triplanner.iti.startingrxjava.Day3.depencdecyinjection.DaggerMyComponent3;
import com.triplanner.iti.startingrxjava.Day3.entities.Post;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by Hanaa on 5/21/2018.
 */

public class PostViewModel extends ViewModel{
    BehaviorSubject<List<Post>> moviesSubject;
    BehaviorSubject<Boolean>loading;
    @Inject
     DataSource dataSource;
    CompositeDisposable disposable;
    Scheduler schedulers;
    @Inject
    public PostViewModel() {
        DaggerMyComponent3.builder().build().inject(this);
        moviesSubject=BehaviorSubject.createDefault(new ArrayList<>());
        loading=BehaviorSubject.createDefault(false);
      //  this.dataSource=new DataSource();
        //this.schedulers=schedulers;
        disposable=new CompositeDisposable();


    }
    public void getData(){
        disposable.add(requestData());
    }
    public Disposable requestData(){
        loading.onNext(true);
       return dataSource.getData()
         .subscribeOn(Schedulers.computation())
         .observeOn(Schedulers.io())
          .doFinally(()->loading.onNext(false))
        .subscribe(moviesSubject::onNext);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
