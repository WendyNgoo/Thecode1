package com.example.navigationtest.ui.manual;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.navigationtest.R;
import com.example.navigationtest.manual;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class SlideshowFragment extends Fragment {

    public SlideshowFragment(){}

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_manual, container, false);
        ImageButton b1 = (ImageButton) root.findViewById(R.id.manualBtn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent (getActivity(), manual.class);
                startActivity(in);

            }
        });


        return root;
    }
}