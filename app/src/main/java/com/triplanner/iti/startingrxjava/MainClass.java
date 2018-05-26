package com.triplanner.iti.startingrxjava;

import android.content.Intent;
import android.renderscript.Short4;

import org.reactivestreams.Subscription;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import javax.security.auth.Subject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

/**
 * Created by Hanaa on 5/16/2018.
 */

public class MainClass {
   public static void main(String ...args){
       Observer<Integer> observer= new Observer<Integer>() {
           @Override
           public void onSubscribe(Disposable d) {

           }

           @Override
           public void onNext(Integer integer) {
               System.out.println(integer);
           }

           @Override
           public void onError(Throwable e) {

           }

           @Override
           public void onComplete() {

           }
       };
       BehaviorSubject<Integer> behaviorSubject=BehaviorSubject.create();
       PublishSubject<Integer> publishSubject=PublishSubject.create();
       ReplaySubject<Integer> replaySubject=ReplaySubject.create();
       AsyncSubject<Integer> asyncSubject=AsyncSubject.create();
       asyncSubject.onNext(1);
       asyncSubject.onNext(2);
       asyncSubject.subscribe(observer);
      /* asyncSubject.onNext(3);
       asyncSubject.onNext(4);*/
       asyncSubject.onComplete();


    }
    void fun(){
        Observable<Integer> observable= Observable.create((s)->{
            Random random=new Random();
            s.onNext(random.nextInt(101));
        });


        ReplaySubject<String> subject=ReplaySubject.create();

        BehaviorSubject<String> subject2=BehaviorSubject.createDefault(new String("hi"));

        subject2.onNext("no");
        observable.map(integer->integer.toString()).subscribe(subject2);
        subject2.subscribe(v->{
            System.out.println("from 1"+v);
        });

        subject2.subscribe(vm->{
            System.out.println("from 2"+vm);
        });
      /* observable.map(integer->integer.toString()).subscribe(subject);
       observable.map(integer->integer.toString()).subscribe(subject);
       observable.map(integer->integer.toString()).subscribe(v->{
           System.out.println("from observable 1"+v);
       });
       observable.map(integer->integer.toString()).subscribe(v->{
           System.out.println("from observable 2"+v);
       });

       subject.onNext("hello");*/
    }

}
