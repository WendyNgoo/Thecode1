package com.example.navigationtest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class bedroom extends AppCompatActivity {
    Button mcondition,mcondition2,mcondition3,mcondition4;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("bedlight");
    DatabaseReference myRef2 = database.getReference("bedfan");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedroom);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mcondition =  findViewById(R.id.lightcontroloff);
        mcondition2 =  findViewById(R.id.lightcontrolon);
        mcondition3 =  findViewById(R.id.fancontroloff);
        mcondition4 =  findViewById(R.id.fancontrolon);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mcondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.setValue("on");
            }
        });
        mcondition2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.setValue("off");
            }
        });
        mcondition3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef2.setValue("on");
            }
        });
        mcondition4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef2.setValue("off");
            }
        });
    }

}


