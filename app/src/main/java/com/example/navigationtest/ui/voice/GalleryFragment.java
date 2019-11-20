package com.example.navigationtest.ui.voice;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.navigationtest.R;
import com.example.navigationtest.voice;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class GalleryFragment extends Fragment{
    ImageButton b1;
public GalleryFragment(){}
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_voice, container, false);
        b1 = (ImageButton) root.findViewById(R.id.voiceBtn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent (getActivity(), voice.class);
                startActivity(in);

            }
        });

        return root;
    }
}


