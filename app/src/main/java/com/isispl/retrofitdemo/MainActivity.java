package com.isispl.retrofitdemo;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.isispl.retrofitdemo.model.Flower;
import com.isispl.retrofitdemo.networkapi.networkapi;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ListActivity {

    Button btn_fetchdata;
    List<Flower> flowerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_fetchdata = (Button)findViewById(R.id.activity_main_btn_fetchdata);
        btn_fetchdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final RestAdapter restAdapter = new RestAdapter.Builder()
                        .setEndpoint("http://services.hanselandpetal.com").build();

                final networkapi flowerapi = restAdapter.create(networkapi.class);

                flowerapi.getData(new Callback<List<Flower>>() {

                    @Override
                    public void success(List<Flower> flowers, Response response) {
                        flowerList = flowers;
                        Adapter adapter = new Adapter(getApplicationContext(), R.layout.row_item, flowerList);
                        setListAdapter(adapter);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(getApplicationContext(),"Failed to load data from server", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}

