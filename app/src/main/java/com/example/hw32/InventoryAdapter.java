package com.example.hw32;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class InventoryAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Integer> images;

    public InventoryAdapter(Context context, ArrayList<Integer> images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.inventory_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView_inventory);
        imageView.setImageResource(images.get(position));

        return convertView;
    }
}
