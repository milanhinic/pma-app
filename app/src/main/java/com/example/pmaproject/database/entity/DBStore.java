package com.example.pmaproject.database.entity;

import android.content.Intent;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "store")
public class DBStore {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "Name")
    private String name;

    @ColumnInfo(name = "Address")
    private String address;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] picture;

    @ColumnInfo(name = "Longitude")
    private double longitude;

    @ColumnInfo(name = "Latitude")
    private double latitude;

    @ColumnInfo(name = "Description")
    private String descriptio;

    @ColumnInfo(name = "Contact")
    private String contact;

    @ColumnInfo(name = "City Id")
    private Integer cityId;

    public DBStore() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getDescriptio() {
        return descriptio;
    }

    public void setDescriptio(String descriptio) {
        this.descriptio = descriptio;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public static class Builder {
        private long id;
        private String name;
        private String address;
        private byte[] picture;
        private double longitude;
        private double latitude;
        private String descriptio;
        private String contact;
        private Integer cityId;

        public Builder(long id) {
            this.id = id;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPicture(byte[] picture) {
            this.picture = picture;
            return this;
        }

        public Builder setLongitude(double longitude) {
            this.longitude = longitude;
            return this;
        }

        public Builder setLatitude(double latitude) {
            this.latitude = latitude;
            return this;
        }

        public Builder setDesription(String descriptio) {
            this.descriptio = descriptio;
            return this;
        }

        public Builder setContact(String contact) {
            this.contact = contact;
            return this;
        }

        public Builder setCityId(Integer cityId) {
            this.cityId = cityId;
            return this;
        }

        public DBStore build() {
            DBStore store = new DBStore();
            store.name = this.name;
            store.address = this.address;
            store.picture = this.picture;
            store.longitude = this.longitude;
            store.latitude = this.latitude;
            store.descriptio = this.descriptio;
            store.contact = this.contact;
            store.cityId = this.cityId;
            return store;
        }
    }
}
