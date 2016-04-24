package com.example.ruwa.chucknorrismvp.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.ruwa.chucknorrismvp.R;
import com.example.ruwa.chucknorrismvp.model.RandomJoke;
import com.example.ruwa.chucknorrismvp.model.Joke;
import com.example.ruwa.chucknorrismvp.presenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    private MainActivityPresenter presenter;

    private TextView status;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create new presenter to gain control
        presenter = new MainActivityPresenter(this);

        // ui initialization and event binding
        status = (TextView) findViewById(R.id.txtstatus);
        findViewById(R.id.btnRandomJoke).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        presenter.getRandomJoke();
    }

    @Override
    public void onRandomJoke(RandomJoke randomJoke) {
        if(randomJoke != null && randomJoke.getJoke() != null){
            Joke value = randomJoke.getJoke();
            status.setText(value.getJoke());
        }
    }

    @Override
    public void showProgressBar(boolean show) {
        if(show){
            progressDialog = ProgressDialog.show(this, null, getString(R.string.loading), false, false);
        }else{
            if(progressDialog != null){
                progressDialog.dismiss();
            }
        }
    }
}
