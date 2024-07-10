package com.example.hw32;

import android.annotation.SuppressLint;
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

    @SuppressLint("NonConstantResourceId")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.inventory_item, parent, false);
        }

        int rarity = images.get(position);
        ImageView imageViewBase = convertView.findViewById(R.id.iV_inventory_base_rarity);
        ImageView imageViewRare = convertView.findViewById(R.id.iV_inventory_rare_rarity);
        ImageView imageViewEpic = convertView.findViewById(R.id.iV_inventory_epic_rarity);
        ImageView imageViewLegend = convertView.findViewById(R.id.iV_inventory_legend_rarity);

        imageViewBase.setVisibility(View.GONE);
        imageViewRare.setVisibility(View.GONE);
        imageViewEpic.setVisibility(View.GONE);
        imageViewLegend.setVisibility(View.GONE);

        if (rarity == R.drawable.circular_button_background) {
            imageViewBase.setVisibility(View.VISIBLE);
        } else if (rarity == R.drawable.circular_button_rare_background) {
            imageViewRare.setVisibility(View.VISIBLE);
        } else if (rarity == R.drawable.circular_button_epic_background) {
            imageViewEpic.setVisibility(View.VISIBLE);
        } else if (rarity == R.drawable.circular_button_legend_background) {
            imageViewLegend.setVisibility(View.VISIBLE);
        }

        return convertView;
    }
}