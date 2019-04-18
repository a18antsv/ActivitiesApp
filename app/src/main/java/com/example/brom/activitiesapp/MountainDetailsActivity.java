package com.example.brom.activitiesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MountainDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mountain_details);

        //Gets all data sent from MainActivity and stores it in variables
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.MOUNTAIN_NAME);
        String location = intent.getStringExtra(MainActivity.MOUNTAIN_LOCATION);
        int height = intent.getIntExtra(MainActivity.MOUNTAIN_HEIGHT, 0);
        int img = intent.getIntExtra(MainActivity.MOUNTAIN_IMAGE, 0);
        String license = intent.getStringExtra(MainActivity.MOUNTAIN_LICENSE);

        //Finds all different view elements and stores them in variable
        ImageView imgImageView = (ImageView) findViewById(R.id.mountain_img);
        TextView nameTextView = (TextView) findViewById(R.id.mountain_name);
        TextView heightTextView = (TextView) findViewById(R.id.mountain_height);
        TextView locationTextView = (TextView) findViewById(R.id.mountain_location);
        TextView licenseTextView = (TextView) findViewById(R.id.mountain_license);

        //Put the information about the clicked mountain into the right view
        imgImageView.setImageResource(img);
        nameTextView.setText(name);
        heightTextView.setText("Height: " + Integer.toString(height) + "m");
        locationTextView.setText("Location: " + location);
        licenseTextView.setText("Image licensed under " + license);
    }
}
