package com.isispl.retrofitdemo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.isispl.retrofitdemo.model.Flower;
import java.util.List;

/**
 * Created by Jaymin581 on 25/06/15.
 */
public class Adapter extends ArrayAdapter<Flower>{

    private Context context;
    private List<Flower> flowerList;
    public Adapter(Context context, int resource, List<Flower> objects){
        super(context, resource, objects);
        this.context = context;
        this.flowerList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.row_item, parent, false);

        Flower flower = flowerList.get(position);

        TextView tv_item = (TextView)view.findViewById(R.id.row_item_tv_itemname);

        tv_item.setText(flower.getName());

        return view;
    }
}


