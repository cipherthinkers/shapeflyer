package com.cipherthinkers.shapeflyer_sample;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by avin on 23/02/17.
 */

public class ImageArrayAdapter extends ArrayAdapter<Integer> {

    public ImageArrayAdapter(Context context, int resource, List<Integer> objects) {
        super(context, resource, objects);
    }

    public ImageArrayAdapter(Context context, int resource, int textViewResourceId, List<Integer> objects) {
        super(context, resource, textViewResourceId, objects);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_shape_item, parent, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.spinner_image);
        imageView.setImageResource(getItem(position));
        imageView.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
        return itemView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent){
        return getView(position,convertView,parent);
    }
}
