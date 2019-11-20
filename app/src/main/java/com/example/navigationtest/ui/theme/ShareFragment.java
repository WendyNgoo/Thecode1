package com.example.navigationtest.ui.theme;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.navigationtest.R;
import com.example.navigationtest.theme;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ShareFragment extends Fragment {
Button b1;
   public ShareFragment(){}

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_theme, container, false);
        ImageButton b1 = (ImageButton) root.findViewById(R.id.themeBtn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent (getActivity(),theme.class);
                startActivity(in);

            }
        });


        return root;
    }
}