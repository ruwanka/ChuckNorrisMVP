package com.example.ruwa.chucknorrismvp.view;

import com.example.ruwa.chucknorrismvp.model.RandomJoke;

/**
 * Created by ruwanka on 4/6/2016.
 * ChuckNorrisMVP is a sample project that shows how to use MVP architectural pattern in android
 */
public interface MainView {

    void onRandomJoke(RandomJoke randomJoke);

    void showProgressBar(boolean show);

}
