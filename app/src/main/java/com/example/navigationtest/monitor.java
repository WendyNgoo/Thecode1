package com.example.navigationtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class monitor extends AppCompatActivity {
    ListView listview;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listview = (ListView) findViewById(R.id.search_monitor);
        ArrayList<String> arrayFood = new ArrayList<>();
        arrayFood.addAll(Arrays.asList(getResources().getStringArray(R.array.features2)));
        adapter = new ArrayAdapter<String>(
                monitor.this,
                android.R.layout.simple_list_item_1,
                arrayFood
        );
        listview.setAdapter(adapter);


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


    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.monitor, menu);
        MenuItem item = menu.findItem(R.id.search_monitor);
        SearchView searchView = (SearchView) item.getActionView();
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String i = String.valueOf(adapter.getItem(position));
                if (i.equals("Bedroom")) {
                    Intent intent300 = new Intent(view.getContext(), bedroom2.class);
                    startActivityForResult(intent300, 0);
                }
                if (i.equals("Kitchen")) {
                    Intent intent300 = new Intent(view.getContext(), kitchen2.class);
                    startActivityForResult(intent300, 1);
                }
                if (i.equals("Bathroom")){
                    Intent intent302 = new Intent(view.getContext(), bathroom2.class);
                    startActivityForResult(intent302,2);
                }
                if (i.equals("Living Room")){
                    Intent intent299 = new Intent(view.getContext(), livingroom2.class);
                    startActivityForResult(intent299,3);
                }
                if (i.equals("Laundry Room")){
                    Intent intent301 = new Intent(view.getContext(), laundryroom2.class);
                    startActivityForResult(intent301,4);
                }
                if (i.equals("Study Room")){
                    Intent intent302 = new Intent(view.getContext(), studyroom2.class);
                    startActivityForResult(intent302,5);
                }


            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}




