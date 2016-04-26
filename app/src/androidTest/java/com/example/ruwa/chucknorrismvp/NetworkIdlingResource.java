package com.example.ruwa.chucknorrismvp;

import android.support.test.espresso.IdlingResource;

import com.example.ruwa.chucknorrismvp.service.NetworkStatus;

/**
 * Created by ruwanka on 4/26/2016.
 * ChuckNorrisMVP is a sample project that shows how to use MVP architectural pattern in android
 */
public class NetworkIdlingResource implements IdlingResource{

    ResourceCallback resourceCallback;

    NetworkStatus networkStatus;

    public NetworkIdlingResource(NetworkStatus networkStatus){
        this.networkStatus = networkStatus;
    }

    @Override
    public String getName() {
        return "network-idling-resource-" + this.getClass().getName();
    }

    @Override
    public boolean isIdleNow() {
        boolean idle = networkStatus.isAPICallsCompleted();
        if(idle && resourceCallback != null) {
            resourceCallback.onTransitionToIdle();
        }
        return idle;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        resourceCallback = callback;
    }
}
