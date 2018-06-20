package com.triplanner.iti.startingrxjava.Day3.depencdecyinjection;

import android.app.Activity;

import com.triplanner.iti.startingrxjava.Day3.fetures.Main3Activity;
import com.triplanner.iti.startingrxjava.Day3.fetures.PostViewActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by Hanaa on 6/19/2018.
 */

@Module (subcomponents = MySubCompoent.class)
public abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract PostViewActivity contributeActivityInjector();
    @ContributesAndroidInjector                            
    abstract Main3Activity contributeActivityInjector2();
    /*@Binds
    @IntoMap
    @ActivityKey(PostViewActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindYourActivityInjectorFactory(MySubCompoent.Builder builder); */
}
