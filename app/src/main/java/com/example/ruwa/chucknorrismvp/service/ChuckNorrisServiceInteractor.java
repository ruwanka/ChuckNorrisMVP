package com.example.ruwa.chucknorrismvp.service;

import com.example.ruwa.chucknorrismvp.model.RandomJoke;

/**
 * Created by ruwanka on 4/6/2016.
 * ChuckNorrisMVP is a sample project that shows how to use MVP architectural pattern in android
 */
public interface ChuckNorrisServiceInteractor {

    void getRandomJoke();

    interface ChuckNorrisServiceCallback{

        void onSuccess(RandomJoke randomJoke);

        void onFailure(String message);

    }

}
