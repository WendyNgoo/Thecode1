package com.example.navigationtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class setname extends AppCompatActivity  {
EditText e1,e2,e3,e4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setname);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Button button1 = findViewById(R.id.set1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeFile();
            }
        });

        setSupportActionBar(toolbar);
        e1 =  findViewById(R.id.setname1);
        e2 =  findViewById(R.id.setname2);
        e3 =  findViewById(R.id.setname3);
        e4 =  findViewById(R.id.setname4);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
    }
    public void writeFile() {
        String textToSave = e1.getText().toString();
        String textToSave2 = e2.getText().toString();
        String textToSave3 = e3.getText().toString();
        String textToSave4 = e4.getText().toString();
        Intent i = new Intent(this, HomePage.class);
        i.putExtra("house2",textToSave2);
        i.putExtra("house1", textToSave);
        i.putExtra("house3",textToSave3);
        i.putExtra("house4", textToSave4);
        startActivity(i);

        try {
            FileOutputStream fileOutputStream = openFileOutput("Tutorial File.txt", MODE_PRIVATE);
            FileOutputStream fileOutputStream2 = openFileOutput("Tutorial File2.txt", MODE_PRIVATE);
            FileOutputStream fileOutputStream3 = openFileOutput("Tutorial File3.txt", MODE_PRIVATE);
            FileOutputStream fileOutputStream4 = openFileOutput("Tutorial File4.txt", MODE_PRIVATE);
            fileOutputStream.write(textToSave.getBytes());
            fileOutputStream2.write(textToSave2.getBytes());
            fileOutputStream3.write(textToSave3.getBytes());
            fileOutputStream4.write(textToSave4.getBytes());
            fileOutputStream.close();
            fileOutputStream2.close();
            fileOutputStream3.close();
            fileOutputStream4.close();

            Toast.makeText(getApplicationContext(), "Saved Changes", Toast.LENGTH_SHORT).show();
            e2.setText(textToSave2);
            e1.setText(textToSave);
            e3.setText(textToSave3);
            e4.setText(textToSave4);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


