package com.triplanner.iti.startingrxjava.Day3.depencdecyinjection;

import com.triplanner.iti.startingrxjava.Day3.fetures.PostViewActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Hanaa on 6/19/2018.
 */

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract PostViewActivity contributeActivityInjector();
}
