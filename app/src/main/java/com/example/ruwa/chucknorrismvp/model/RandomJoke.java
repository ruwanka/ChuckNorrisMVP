package com.example.ruwa.chucknorrismvp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RandomJoke implements Parcelable{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("value")
    @Expose
    private Joke joke;

    protected RandomJoke(Parcel in) {
        type = in.readString();
        joke = in.readParcelable(Joke.class.getClassLoader());
    }

    public static final Creator<RandomJoke> CREATOR = new Creator<RandomJoke>() {
        @Override
        public RandomJoke createFromParcel(Parcel in) {
            return new RandomJoke(in);
        }

        @Override
        public RandomJoke[] newArray(int size) {
            return new RandomJoke[size];
        }
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Joke getJoke() {
        return joke;
    }

    public void setJoke(Joke joke) {
        this.joke = joke;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(type);
        parcel.writeParcelable(joke, flags);
    }
}
