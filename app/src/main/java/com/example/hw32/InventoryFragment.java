package com.example.hw32;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class InventoryFragment extends Fragment {
    private static final String ARG_IMAGES = "inventory_images";
    private ArrayList<Integer> inventoryImages;

    public static InventoryFragment newInstance(ArrayList<Integer> images) {
        InventoryFragment fragment = new InventoryFragment();
        Bundle args = new Bundle();
        args.putIntegerArrayList(ARG_IMAGES, images);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inventory, container, false);
        if (getArguments() != null) {
            inventoryImages = getArguments().getIntegerArrayList(ARG_IMAGES);
        }

        GridView gridView = view.findViewById(R.id.gridView_inventory);
        InventoryAdapter adapter = new InventoryAdapter(getContext(), inventoryImages);
        gridView.setAdapter(adapter);

        Button btnBack = view.findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });

        return view;
    }
}