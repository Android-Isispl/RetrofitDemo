package com.isispl.retrofitdemo.networkapi;

import com.isispl.retrofitdemo.model.Flower;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Jaymin581 on 25/06/15.
 */
public interface networkapi {
    @GET("/feeds/flowers.json")
    public void getData(Callback<List<Flower>> response);
}
