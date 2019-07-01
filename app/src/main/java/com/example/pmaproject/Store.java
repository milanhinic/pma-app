package com.example.pmaproject;

public class Store {
    private String text;
    private  String imageURL;

    public Store(String text, String imageURL){
        this.text = text;
        this.imageURL = imageURL;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
