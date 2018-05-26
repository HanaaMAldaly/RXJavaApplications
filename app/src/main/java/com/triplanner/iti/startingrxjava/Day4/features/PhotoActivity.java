package com.triplanner.iti.startingrxjava.Day4.features;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;


import com.triplanner.iti.startingrxjava.Day4.entities.Photo;
import com.triplanner.iti.startingrxjava.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;

public class PhotoActivity extends AppCompatActivity {
    @BindView(R.id.photo_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar2)
    ProgressBar progressBar;
    PhotoViewModel photoViewModel;
    CompositeDisposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);
        disposable=new CompositeDisposable();
        photoViewModel=new PhotoViewModel();
        bindRecycleView(photoViewModel.photos);
        disposable.add(photoViewModel.photos
                .observeOn(AndroidSchedulers.mainThread())
                .map((photos1)->new PhotoAdapter(this,photoViewModel.photos))
                .subscribe(recyclerView::setAdapter));
        disposable.add(photoViewModel.loading
                .observeOn(AndroidSchedulers.mainThread())
                .map((load)->load? View.VISIBLE:View.GONE)
                .subscribe(progressBar::setVisibility));
    }

    public void bindRecycleView(BehaviorSubject<List<Photo>> photos){
        PhotoAdapter photoAdapter=new PhotoAdapter(this,photos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.setAdapter(photoAdapter);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}
