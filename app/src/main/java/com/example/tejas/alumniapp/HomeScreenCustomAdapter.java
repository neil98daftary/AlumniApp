package com.example.tejas.alumniapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tejas on 12-10-2016.
 */
public class HomeScreenCustomAdapter extends ArrayAdapter<String> {

    public HomeScreenCustomAdapter(Context context, String[] branches ) {
        super(context,R.layout.homescreencustomrow ,branches);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        View customView=layoutInflater.inflate(R.layout.homescreencustomrow, parent, false);

        String fooditem=getItem(position);
        TextView largetextView=(TextView) customView.findViewById(R.id.largetextView);


        largetextView.setText(fooditem);

        return customView;
    }
}

