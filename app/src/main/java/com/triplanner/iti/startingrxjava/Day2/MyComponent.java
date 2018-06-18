package com.triplanner.iti.startingrxjava.Day2;

/**
 * Created by Hanaa on 6/17/2018.
 */

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {Module.class})
public interface MyComponent {
    void inject (View view);
    void inject (ModelView view);
}
