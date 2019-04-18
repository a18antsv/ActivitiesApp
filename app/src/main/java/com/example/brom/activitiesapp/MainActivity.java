package com.example.brom.activitiesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] mountainNames = {"Matterhorn","Mont Blanc","Denali"};
    private String[] mountainLocations = {"Alps","Alps","Alaska"};
    private int[] mountainHeights = {4478,4808,6190};
    private int[] mountainImages = {R.drawable.matterhorn, R.drawable.mont_blanc, R.drawable.denali};
    private String[] mountainLicenses = {"CC0", "Public Domain", "CC BY 2.0"};

    private static final String TAG = "MainActivity";
    public static final String
            MOUNTAIN_NAME = "MOUNTAIN_NAME",
            MOUNTAIN_LOCATION = "MOUNTAIN_LOCATION",
            MOUNTAIN_HEIGHT = "MOUNTAIN_HEIGHT",
            MOUNTAIN_IMAGE = "MOUNTAIN_IMAGE",
            MOUNTAIN_LICENSE = "MOUNTAIN_LICENSE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate() called");

        //List that will be populated with Mountain-objects
        final List<Mountain> mountains = new ArrayList<>();

        //List that will be popultaed with only names of Mountains
        List<String> names = new ArrayList<>();

        for(int i = 0; i < mountainNames.length; i++) {
            //Creating Mountain object with info from the the first position in each of the 5 arrays and adds to list
            mountains.add(new Mountain(
                    mountainNames[i],
                    mountainHeights[i],
                    mountainLocations[i],
                    mountainImages[i],
                    mountainLicenses[i]))
            ;
            //Adds only mountain name to another list, use to populate ListView
            names.add(mountains.get(i).getName());
        }

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.listitem_textview, R.id.item_textview, names);

        ListView listView = (ListView) findViewById(R.id.my_listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Creates intent and passes info to it by key to be able to use it in other activity
                Intent intent = new Intent(MainActivity.this, MountainDetailsActivity.class);
                intent.putExtra(MOUNTAIN_NAME, mountains.get(i).getName());
                intent.putExtra(MOUNTAIN_LOCATION, mountains.get(i).getLocation());
                intent.putExtra(MOUNTAIN_HEIGHT, mountains.get(i).getHeight());
                intent.putExtra(MOUNTAIN_IMAGE, mountains.get(i).getImage());
                intent.putExtra(MOUNTAIN_LICENSE, mountains.get(i).getLicense());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}
