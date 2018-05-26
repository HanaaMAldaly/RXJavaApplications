package com.triplanner.iti.startingrxjava.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.triplanner.iti.startingrxjava.R;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class LoginView extends AppCompatActivity {
    ProgressBar progressBar;
    Button button;
    TextView textView;
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progressBar);
        button=findViewById(R.id.button);
        textView=findViewById(R.id.textView);
        loginViewModel= new LoginViewModel();
        button.setOnClickListener((view) -> {
            loginViewModel.requestLogin();
        });
        loginViewModel.textResult.observeOn(AndroidSchedulers.mainThread()).subscribe(textView::setText);
        loginViewModel.loginResut.observeOn(AndroidSchedulers.mainThread()).subscribe(result-> Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show());
        loginViewModel.loading.observeOn(AndroidSchedulers.mainThread()).map(loading->loading? View.VISIBLE:View.GONE).subscribe(result->
        {
            progressBar.setVisibility(result);
            Log.i("TAG", "subscribe from view ");
        });
    }
}
