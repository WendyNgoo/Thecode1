package com.example.navigationtest.ui.monitor;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.navigationtest.R;
import com.example.navigationtest.monitor;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ToolsFragment extends Fragment {

    public ToolsFragment(){}

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_monitor, container, false);
        ImageButton b1 = (ImageButton) root.findViewById(R.id.monitorBtn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent (getActivity(), monitor.class);
                startActivity(in);

            }
        });


        return root;
    }
}