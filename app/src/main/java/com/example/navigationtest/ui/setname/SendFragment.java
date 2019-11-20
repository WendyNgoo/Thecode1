package com.example.navigationtest.ui.setname;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.navigationtest.R;
import com.example.navigationtest.setname;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class SendFragment extends Fragment {

    public SendFragment(){}

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_setname, container, false);
       ImageButton b1 = (ImageButton) root.findViewById(R.id.setnameBtn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent (getActivity(), setname.class);
                startActivity(in);

            }
        });


        return root;
    }
}