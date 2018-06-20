package com.triplanner.iti.startingrxjava.Day3.depencdecyinjection;

import com.triplanner.iti.startingrxjava.Day3.fetures.PostViewActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by Hanaa on 6/20/2018.
 */
@Subcomponent
public interface MySubCompoent extends AndroidInjector<PostViewActivity>{
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<PostViewActivity>{}

}
