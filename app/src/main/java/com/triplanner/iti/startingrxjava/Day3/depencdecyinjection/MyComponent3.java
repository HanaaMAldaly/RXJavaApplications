package com.triplanner.iti.startingrxjava.Day3.depencdecyinjection;

import com.triplanner.iti.startingrxjava.Day3.Model.DataSource;
import com.triplanner.iti.startingrxjava.Day3.MyApplication;
import com.triplanner.iti.startingrxjava.Day3.fetures.PostAdapter;
import com.triplanner.iti.startingrxjava.Day3.fetures.PostViewActivity;
import com.triplanner.iti.startingrxjava.Day3.fetures.PostViewModel;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * Created by Hanaa on 6/18/2018.
 */

@Component(modules = {Module3.class,ActivityModule.class, AndroidInjectionModule.class})
@Singleton
public interface MyComponent3 extends AndroidInjector<MyApplication> {
    void inject(PostViewActivity postViewActivity);
    void inject(PostViewModel postViewModel);
    void inject(DataSource dataSource);
    void inject(PostAdapter postAdapter);
    //void inject(MyApplication myApplication);
}
