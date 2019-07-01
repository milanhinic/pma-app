package com.example.pmaproject.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "city")
public class DBCity {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "Name")
    private String name;

    @ColumnInfo(name = "Longitude")
    private double longitude;

    @ColumnInfo(name = "Latitude")
    private double latitude;

    public DBCity() {
    }

    public DBCity(DBCity.Builder builder) {
        id = builder.id;
        name = builder.name;
        longitude = builder.longitude;
        latitude = builder.latitude;
    }

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

    public static class Builder {

        private long id;
        private String name;
        private double longitude;
        private double latitude;

        public Builder(long id) {
            this.id = id;
        }

        public Builder setName(String name) {
            this.name = name;
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

        public DBCity build() {
            DBCity city  = new DBCity();
            city.name = this.name;
            city.longitude = this.longitude;
            city.latitude = this.latitude;
            return city;
        }

    }

}
