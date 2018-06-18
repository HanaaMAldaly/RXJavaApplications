package com.triplanner.iti.startingrxjava.Day2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.triplanner.iti.startingrxjava.R;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class View extends AppCompatActivity {
    ListView listView;
    Button button;
    @Inject
    ModelView modelView;
    @BindViews({R.id.listView,R.id.button2})
    List<android.view.View> views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        listView=findViewById(R.id.listView);
        button=findViewById(R.id.button2);
        ButterKnife.bind(this);
        ((MyApplication)getApplication()).getMyComponent().inject(this);
        //modelView=new ModelView();
        modelView.requestChange();
        for(android.view.View view : views) {
           // Toast.makeText(getApplicationContext(), view.getId()+"", Toast.LENGTH_SHORT).show();
            Log.i("Tag",view.getId()+"");
        };
       /* button.setOnClickListener(view -> {

        });*/

        modelView.number.map(arr->new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,arr)).subscribe(listView::setAdapter);
    }
    @OnClick(R.id.button2)
        void generateData(){
        modelView.requestChange();
        }
}
