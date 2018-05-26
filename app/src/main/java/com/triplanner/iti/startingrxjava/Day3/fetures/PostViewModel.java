package com.triplanner.iti.startingrxjava.Day3.fetures;

import android.arch.lifecycle.ViewModel;

import com.triplanner.iti.startingrxjava.Day3.Model.DataSource;
import com.triplanner.iti.startingrxjava.Day3.entities.Post;

import java.util.List;

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
    DataSource dataSource;
    CompositeDisposable disposable;

    public PostViewModel() {
        moviesSubject=BehaviorSubject.create();
        loading=BehaviorSubject.createDefault(false);
        dataSource=new DataSource();
        disposable=new CompositeDisposable();


    }
    public void getData(){
        disposable.add(requestData());
    }
    public Disposable requestData(){
       return dataSource.getData()
         .subscribeOn(Schedulers.io())
         .observeOn(AndroidSchedulers.mainThread())
        .subscribe(moviesSubject::onNext);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
