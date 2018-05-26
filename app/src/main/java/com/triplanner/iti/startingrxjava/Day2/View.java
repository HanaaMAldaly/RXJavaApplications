package com.triplanner.iti.startingrxjava.Day2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.triplanner.iti.startingrxjava.R;

public class View extends AppCompatActivity {
    ListView listView;
    Button button;
    ModelView modelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        listView=findViewById(R.id.listView);
        button=findViewById(R.id.button2);
        modelView=new ModelView();
        modelView.requestChange();
        button.setOnClickListener(view -> {
            modelView.requestChange();
        });

        modelView.number.map(arr->new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,arr)).subscribe(listView::setAdapter);
    }
}
