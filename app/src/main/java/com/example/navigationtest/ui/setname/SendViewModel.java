package com.example.navigationtest.ui.setname;

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

import com.example.navigationtest.R;
import com.example.navigationtest.bedroom;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;

public class SendViewModel extends AppCompatActivity {
    ListView listview;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

        listview = (ListView)findViewById(R.id.search_manual);
        ArrayList<String> arrayFood = new ArrayList<>();
        arrayFood.addAll(Arrays.asList(getResources().getStringArray(R.array.features2)));
        listview.setAdapter(adapter);
        adapter = new ArrayAdapter<String>(
                SendViewModel.this,
                android.R.layout.simple_list_item_1,
                arrayFood
        );

        listview.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.manual, menu);
        MenuItem item = menu.findItem(R.id.search_manual);
        SearchView searchView = (SearchView) item.getActionView();
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,int position, long l) {
                String i = String.valueOf(adapter.getItem(position));
                if (i.equals("Bedroom")){
                    Intent intent300 = new Intent(view.getContext(), bedroom.class);
                    startActivityForResult(intent300,0);
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

