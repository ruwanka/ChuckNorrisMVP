package com.example.ruwa.chucknorrismvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Joke {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("joke")
    @Expose
    private String joke;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

}
