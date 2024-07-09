package com.example.hw32;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class CounterFragment extends Fragment {
    private static final String PREFS_NAME = "counter_prefs";
    private static final String KEY_COUNTER = "counter";
    private int counter = 0;
    private TextView tvCounter;
    private ArrayList<Integer> inventoryImages;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_counter, container, false);
        tvCounter = view.findViewById(R.id.tv_counter);
        ImageButton btnIncrement = view.findViewById(R.id.btn_increment);
        Button btnDecrement = view.findViewById(R.id.btn_decrement);
        Button btnInventory = view.findViewById(R.id.btn_inventory);

        inventoryImages = new ArrayList<>();

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        counter = sharedPreferences.getInt(KEY_COUNTER, 0);
        tvCounter.setText(String.valueOf(counter));

        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                tvCounter.setText(String.valueOf(counter));
                saveCounterValue();
                inventoryImages.add(R.drawable.item_to_inventory);
            }
        });

        btnDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter > 0) {
                    counter--;
                    tvCounter.setText(String.valueOf(counter));
                    saveCounterValue();
                }
            }
        });

        btnInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InventoryFragment inventoryFragment = InventoryFragment.newInstance(inventoryImages);
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_counter_fragment_view, inventoryFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    private void saveCounterValue() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_COUNTER, counter);
        editor.apply();
    }
}
