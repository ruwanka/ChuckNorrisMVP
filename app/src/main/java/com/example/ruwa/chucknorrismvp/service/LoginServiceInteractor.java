package com.example.ruwa.chucknorrismvp.service;

/**
 * Created by ruwanka on 4/6/2016.
 * ChuckNorrisMVP is a sample project that shows how to use MVP architectural pattern in android
 */
interface LoginServiceInteractor {

    interface HttpServiceCallback{

        void onResponse(String msg);

        void onFailure();

    }

    void login();

}
