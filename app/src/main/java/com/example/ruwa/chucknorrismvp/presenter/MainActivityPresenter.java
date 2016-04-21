package com.example.ruwa.chucknorrismvp.presenter;

import com.example.ruwa.chucknorrismvp.model.RandomJoke;
import com.example.ruwa.chucknorrismvp.service.ChuckNorrisService;
import com.example.ruwa.chucknorrismvp.service.ChuckNorrisServiceInteractor;
import com.example.ruwa.chucknorrismvp.view.MainActivity;
import com.example.ruwa.chucknorrismvp.view.MainView;

/**
 * Created by ruwanka on 4/6/2016.
 * ChuckNorrisMVP is a sample project that shows how to use MVP architectural pattern in android
 */

public class MainActivityPresenter implements MainPresenter, ChuckNorrisServiceInteractor.ChuckNorrisServiceCallback{

    private final MainView view;

    private final ChuckNorrisService service;

    public MainActivityPresenter(MainActivity activity){
        view = activity;

        // init service
        service = new ChuckNorrisService(this);
    }

    @Override
    public void getRandomJoke() {
        service.getRandomJoke();
        view.showProgressBar(true);
    }

    @Override
    public void onSuccess(RandomJoke randomJoke) {
        view.onRandomJoke(randomJoke);
        view.showProgressBar(false);
    }

    @Override
    public void onFailure(String message) {
        view.showProgressBar(false);
    }
}
