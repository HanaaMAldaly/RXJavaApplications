package com.triplanner.iti.startingrxjava.MVP.screens;

import com.triplanner.iti.startingrxjava.Day4.entities.Photo;
import com.triplanner.iti.startingrxjava.MVP.Model.DataReprositery;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Hanaa on 6/15/2018.
 */

public class PhotoPresenter implements Contract.PresenterContract {
    List<Photo> photos;
    DataReprositery dataReprositery=new DataReprositery();
    Contract.ViewContract view;

    PhotoPresenter(Contract.ViewContract view){
        this.view=view;
    }

    @Override
    public void requestData() {
        dataReprositery.getPhoto()
         .subscribeOn(Schedulers.io())
        .doOnSubscribe((disposable)->view.showProgress())
        .observeOn(AndroidSchedulers.mainThread())
        .doFinally(view::hideProgress)
        .subscribe((photos)->{
            this.photos=photos;
            view.showData();});

    }
}
