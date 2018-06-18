package com.triplanner.iti.startingrxjava.Day2;

import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by Hanaa on 5/19/2018.
 */

public class ModelView extends ViewModel {
    BehaviorSubject<ArrayList<Integer>> number;
    @Inject
    Model model;
    BehaviorSubject<Boolean>loading;
    @Inject
    public ModelView(){
        number=BehaviorSubject.createDefault(new ArrayList<>());
        loading=BehaviorSubject.createDefault(false);
      DaggerMyComponent.builder().build().inject(this);
    }
    public void requestChange(){
        Observable.fromCallable(()->model.generateData())
                .doOnNext((it)->loading.onNext(true))
                .doFinally(()->loading.onNext(false))
                .subscribe((result)->number.onNext(result));
    }

    @Override
    protected void onCleared() {
        number.onComplete();
        super.onCleared();
    }
}
