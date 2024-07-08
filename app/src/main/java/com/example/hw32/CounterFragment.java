package com.example.hw32;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.Nullable;


public class CounterFragment extends Fragment {
    private int counter = 0;
    private TextView tvCounter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_counter, container, false);
        tvCounter = view.findViewById(R.id.tv_counter);
        ImageButton btnIncrement = view.findViewById(R.id.btn_increment);
        Button btnDecrement = view.findViewById(R.id.btn_decrement);

        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                tvCounter.setText(String.valueOf(counter));
            }
        });

        btnDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter > 0) {
                    counter--;
                    tvCounter.setText(String.valueOf(counter));
                }
            }
        });

        return view;
    }
}
