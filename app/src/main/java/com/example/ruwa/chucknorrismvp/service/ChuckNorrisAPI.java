package com.example.ruwa.chucknorrismvp.service;

import com.example.ruwa.chucknorrismvp.model.RandomJoke;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ruwanka on 4/21/2016.
 * ChuckNorrisMVP is a sample project that shows how to use MVP architectural pattern in android
 */
interface ChuckNorrisAPI {

    @GET("jokes/random")
    Call<RandomJoke> getRandomJoke();

}
