package com.triplanner.iti.startingrxjava.Day2;

import android.app.Application;

/**
 * Created by Hanaa on 6/17/2018.
 */

public class MyApplication extends Application {
    MyComponent myComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        myComponent=DaggerMyComponent.builder().build();
    }

    public MyComponent getMyComponent() {
        return myComponent;
    }
}
