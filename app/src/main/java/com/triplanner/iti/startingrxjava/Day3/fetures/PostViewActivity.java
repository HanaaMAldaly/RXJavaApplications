package com.triplanner.iti.startingrxjava.Day3.fetures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.triplanner.iti.startingrxjava.Day3.Model.DataSource;
import com.triplanner.iti.startingrxjava.Day3.entities.Post;
import com.triplanner.iti.startingrxjava.Day3.network.APIInterface;
import com.triplanner.iti.startingrxjava.Day3.network.RetrofitClient;
import com.triplanner.iti.startingrxjava.R;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class PostViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CompositeDisposable disposable;
    APIInterface apiInterface;
    PostViewModel postViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_view);
        recyclerView=findViewById(R.id.recyclerView);
        DataSource dataSource=new DataSource();
        postViewModel=new PostViewModel();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        postViewModel.getData();
        disposable=new CompositeDisposable();
        disposable.add(postViewModel.moviesSubject
                .map((posts)->new PostAdapter(this,posts))
                .subscribe(recyclerView::setAdapter));
       /*
        Retrofit retrofit= RetrofitClient.getInstance();
        apiInterface=retrofit.create(APIInterface.class);
        //fetchData();
        */
    }

    private void fetchData() {
        disposable.add(apiInterface.getPosts()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map((posts -> new PostAdapter(this,posts)))
        .subscribe(recyclerView::setAdapter)
        );

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}
