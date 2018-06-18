package com.triplanner.iti.startingrxjava.Day3;

import android.app.Activity;
import android.app.Application;

import com.triplanner.iti.startingrxjava.Day3.depencdecyinjection.DaggerMyComponent3;
import com.triplanner.iti.startingrxjava.Day3.depencdecyinjection.Module3;
import com.triplanner.iti.startingrxjava.Day3.depencdecyinjection.MyComponent3;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by Hanaa on 6/18/2018.
 */

public class MyApplication extends Application implements HasActivityInjector {
    MyComponent3 myComponent3;
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
    @Override
    public void onCreate() {
        super.onCreate();
        DaggerMyComponent3.builder().module3(new Module3(getApplicationContext())).build().inject(this);

    }

    public MyComponent3 getMyComponent3() {
        return myComponent3;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
