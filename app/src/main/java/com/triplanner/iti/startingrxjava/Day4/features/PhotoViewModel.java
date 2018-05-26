package com.triplanner.iti.startingrxjava.Day4.features;

import android.arch.lifecycle.ViewModel;

import com.triplanner.iti.startingrxjava.Day4.DataSource;
import com.triplanner.iti.startingrxjava.Day4.entities.Photo;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by Hanaa on 5/25/2018.
 */

public class PhotoViewModel extends ViewModel {
    BehaviorSubject <Boolean> loading;
    BehaviorSubject <List<Photo>> photos;
    DataSource dataSource;
    CompositeDisposable disposable;

    public PhotoViewModel(){
        loading=BehaviorSubject.createDefault(false);
        photos=BehaviorSubject.create();
        dataSource=new DataSource();
        disposable=new CompositeDisposable();
        disposable.add(requestDataFromDataSource());
    }
    public void requestData(){
        disposable.add(requestDataFromDataSource());
    }
    private Disposable requestDataFromDataSource(){

        loading.onNext(true);
        return DataSource.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .doFinally(()->loading.onNext(false))
                .subscribe(photos::onNext);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
