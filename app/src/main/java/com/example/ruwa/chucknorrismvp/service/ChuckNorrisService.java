package com.example.ruwa.chucknorrismvp.service;

import com.example.ruwa.chucknorrismvp.model.RandomJoke;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ruwanka on 4/6/2016.
 * ChuckNorrisMVP is a sample project that shows how to use MVP architectural pattern in android
 */
public class ChuckNorrisService implements ChuckNorrisServiceInteractor {

    private final ChuckNorrisAPI chuckNorrisAPI;

    private final ChuckNorrisServiceCallback serviceCallback;

    public ChuckNorrisService(ChuckNorrisServiceCallback callback){
        this.serviceCallback = callback;
        chuckNorrisAPI = ServiceFactory.create(ChuckNorrisAPI.class);
    }

    @Override
    public void getRandomJoke() {
        chuckNorrisAPI.getRandomJoke().enqueue(new Callback<RandomJoke>() {
            @Override
            public void onResponse(Call<RandomJoke> call, Response<RandomJoke> response) {
                RandomJoke randomJoke = response.body();
                if(response.code() == HttpURLConnection.HTTP_OK && randomJoke != null){
                    serviceCallback.onSuccess(randomJoke);
                }
            }

            @Override
            public void onFailure(Call<RandomJoke> call, Throwable t) {
                serviceCallback.onFailure(t.getMessage());
            }
        });
    }

}
