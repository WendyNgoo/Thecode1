package com.example.navigationtest;

import android.os.Bundle;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;

public class theme extends AppCompatActivity {
    SwitchCompat switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        Toolbar toolbar = findViewById(R.id.toolbar);
        switch1 = findViewById(R.id.switch1);
        setSupportActionBar(toolbar);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    getDelegate().setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                } else {

                    getDelegate().setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }

            }

        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();

    }

}