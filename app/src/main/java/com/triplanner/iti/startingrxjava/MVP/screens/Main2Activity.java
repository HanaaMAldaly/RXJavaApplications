package com.triplanner.iti.startingrxjava.MVP.screens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.triplanner.iti.startingrxjava.Day4.features.PhotoAdapter;
import com.triplanner.iti.startingrxjava.R;

import javax.security.auth.Subject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.subjects.BehaviorSubject;

public class Main2Activity extends AppCompatActivity implements Contract.ViewContract {

    @BindView(R.id.progressBar3)
    ProgressBar progressBar;
    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    PhotoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        progressBar=findViewById(R.id.progressBar3);
        presenter=new PhotoPresenter(this);
        presenter.requestData();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void showData() {
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(new PhotoAdapter(this, BehaviorSubject.createDefault(presenter.photos)));


    }
}
