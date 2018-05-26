package com.triplanner.iti.startingrxjava.Day2;

import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by Hanaa on 5/19/2018.
 */

public class ModelView extends ViewModel {
    BehaviorSubject<ArrayList<Integer>> number;
    Model model;
    BehaviorSubject<Boolean>loading;
    public ModelView(){
        number=BehaviorSubject.createDefault(new ArrayList<>());
        model=new Model();
    }
    public void requestChange(){
        Observable.fromCallable(()->model.generateData())
                .subscribe((result)->number.onNext(result));
    }

    @Override
    protected void onCleared() {
        number.onComplete();
        super.onCleared();
    }
}
