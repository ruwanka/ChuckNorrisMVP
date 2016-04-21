package com.example.ruwa.chucknorrismvp.service;

import android.os.AsyncTask;

/**
 * Created by ruwanka on 4/6/2016.
 * ChuckNorrisMVP is a sample project that shows how to use MVP architectural pattern in android
 */
public class LoginService implements LoginServiceInteractor {

    private HttpServiceCallback callback;

    public LoginService(HttpServiceCallback callback){
        this.callback = callback;
    }

    public LoginService(){}

    public void setCallback(HttpServiceCallback callback) {
        this.callback = callback;
    }

    @Override
    public void login() {
        AsyncTask<Void, Void, Boolean> task = new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... params) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    return false;
                }
                return true;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                if(aBoolean){
                    callback.onResponse("login successful");
                }else{
                    callback.onFailure();
                }
            }
        };
        task.execute();
    }

}
