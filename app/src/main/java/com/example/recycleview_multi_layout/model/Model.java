package com.example.recycleview_multi_layout.model;

public class Model {

    private String name;
    private int imageId;

    public Model(String name, int imageId){
        this.name = name;
        this.imageId = imageId;

    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}