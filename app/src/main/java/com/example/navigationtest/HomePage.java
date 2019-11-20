package com.example.navigationtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Button b1 = findViewById(R.id.house1);
        b1.setOnClickListener(this);
        Button b2 = findViewById(R.id.house2);
        b2.setOnClickListener(this);
        Button b3 = findViewById(R.id.house3);
        b3.setOnClickListener(this);
        Button b4 = findViewById(R.id.house4);
        b4.setOnClickListener(this);
        Intent intent = getIntent();
        String message1 = intent.getStringExtra("house1");
        String message2 = intent.getStringExtra("house2");
        String message3 = intent.getStringExtra("house3");
        String message4 = intent.getStringExtra("house4");
        b1.setText(message1);
        b2.setText(message2);
        b3.setText(message3);
        b4.setText(message4);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.house1:
                Intent intent400 = new Intent(this, MainActivity.class);
                this.startActivity(intent400);
                break;
            case R.id.house2:
                Intent intent = new Intent(this, MainActivity.class);
                this.startActivity(intent);
                break;
            case R.id.house3:
                Intent intent40 = new Intent(this, MainActivity.class);
                this.startActivity(intent40);
                break;
            case R.id.house4:
                Intent intent4 = new Intent(this, MainActivity.class);
                this.startActivity(intent4);
                break;
        }

    }
}
