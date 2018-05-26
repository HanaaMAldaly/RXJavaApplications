package com.triplanner.iti.startingrxjava.login;

import android.util.Log;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by Hanaa on 5/18/2018.
 */

public class LoginViewModel {
    LoginModel loginModel;
    BehaviorSubject<Boolean> loading;
    BehaviorSubject<Boolean> loginResut;
    BehaviorSubject<String> textResult;
    public LoginViewModel(){
        loading=BehaviorSubject.createDefault(false);
        loginResut=BehaviorSubject.createDefault(new Boolean(false));
        textResult=BehaviorSubject.createDefault("not Loading");
        loginModel=new LoginModel();
    }
    public void requestLogin() {
        loading.onNext(true);
        textResult.onNext("Loading");
        Observable.fromCallable(()-> loginModel.login("",""))
        .observeOn(Schedulers.io())
        .subscribeOn(Schedulers.computation())
        .doFinally(()->{loading.onNext(false);
        textResult.onNext("not Loading");})
        .subscribe(new Observer<Boolean>() {
                       @Override
                       public void onSubscribe(Disposable d) {

                       }

                       @Override
                       public void onNext(Boolean aBoolean) {
                        loginResut.onNext(aBoolean);
                       }

                       @Override
                       public void onError(Throwable e) {

                       }

                       @Override
                       public void onComplete() {

                       }
                   }
        );

    }
}
