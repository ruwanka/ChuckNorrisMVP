package com.example.ruwa.chucknorrismvp.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.ruwa.chucknorrismvp.R;
import com.example.ruwa.chucknorrismvp.model.RandomJoke;
import com.example.ruwa.chucknorrismvp.presenter.MainActivityPresenter;
import com.example.ruwa.chucknorrismvp.service.NetworkStatus;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener, NetworkStatus {

    private MainActivityPresenter presenter;

    private TextView status;

    private ProgressDialog progressDialog;

    // store network status, initially should be false since layout has not been initialized
    private boolean isIdle = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  set isIdle to true, network calls has not been started yet
        isIdle = true;

        // create new presenter to gain control
        presenter = new MainActivityPresenter(this);

        // ui initialization and event binding
        status = (TextView) findViewById(R.id.txtstatus);
        findViewById(R.id.btnRandomJoke).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        presenter.getRandomJoke();
        isIdle = false;
    }

    @Override
    public void onRandomJoke(RandomJoke randomJoke) {
        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra("joke", randomJoke.getJoke());
        startActivity(intent);
        // network calls completed, set isIdle to true
        isIdle = true;
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

    @Override
    public boolean isAPICallsCompleted() {
        return isIdle;
    }
}
