package com.example.ayur;

public class ListItems {
    public int images ;

    public String data;


    public ListItems() {
    }

    public ListItems( int images, String data) {
        this.images = images;
        this.data = data;

    }




    public String getData() {
        return data;
    }

    public int getImage() {
        return images;
    }
}
