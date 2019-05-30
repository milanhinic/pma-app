package com.example.pmaproject.models;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Store {

    private String id;
    private String name;
    private String address;
    private String pictureLink;
    private Double longitude;
    private Double latitude;
    private String desctiption;
    private String contact;

    public Store() {
    }

    public Store(String id,String name, String address, String pictureLink, Double longitude, Double latitude, String desctiption, String contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.pictureLink = pictureLink;
        this.longitude = longitude;
        this.latitude = latitude;
        this.desctiption = desctiption;
        this.contact = contact;
    }

    public Store(String name, String address, String pictureLink, Double longitude, Double latitude, String desctiption, String contact) {
        this.name = name;
        this.address = address;
        this.pictureLink = pictureLink;
        this.longitude = longitude;
        this.latitude = latitude;
        this.desctiption = desctiption;
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getDesctiption() {
        return desctiption;
    }

    public void setDesctiption(String desctiption) {
        this.desctiption = desctiption;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
