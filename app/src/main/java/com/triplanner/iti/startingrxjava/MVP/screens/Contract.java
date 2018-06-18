package com.triplanner.iti.startingrxjava.MVP.screens;

import io.reactivex.disposables.Disposable;

/**
 * Created by Hanaa on 6/15/2018.
 */

public interface Contract {
     interface ViewContract{
         void showProgress();
         void hideProgress();
         void showData();

     }
    interface PresenterContract{
         void requestData();

    }
}
