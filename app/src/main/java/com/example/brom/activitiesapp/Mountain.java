package com.example.brom.activitiesapp;

/**
 * Created by Anton on 2019-04-18.
 */

public class Mountain {
    private String name;
    private int height;
    private String location;
    private int img;
    private String license;

    public Mountain(String name, int height, String location, int img, String license) {
        this.name = name;
        this.height = height;
        this.location = location;
        this.img = img;
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public String getLocation() {
        return location;
    }

    public int getImage() {
        return img;
    }

    public String getLicense() {
        return license;
    }
}
