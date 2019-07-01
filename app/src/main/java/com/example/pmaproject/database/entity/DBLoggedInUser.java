package com.example.pmaproject.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "loggedInUser")
public class DBLoggedInUser {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "First Name")
    private String firstName;

    @ColumnInfo(name = "Last name")
    private String lastName;

    @ColumnInfo(name = "Email")
    private String email;

    @ColumnInfo(name = "Password")
    private String password;

    @ColumnInfo(name = "Default City")
    private Integer defaultCity;

    @ColumnInfo(name = "perimetar")
    private Integer perimetar;

    public DBLoggedInUser() {
    }

    public DBLoggedInUser(DBLoggedInUser.Builder builder) {
        id = builder.id;
        firstName = builder.firstName;
        lastName = builder.lastName;
        email = builder.email;
        password = builder.password;
        defaultCity = builder.defaultCity;
        perimetar = builder.perimetar;

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDefaultCity() {
        return defaultCity;
    }

    public void setDefaultCity(Integer defaultCity) {
        this.defaultCity = defaultCity;
    }

    public Integer getPerimetar() {
        return perimetar;
    }

    public void setPerimetar(Integer perimetar) {
        this.perimetar = perimetar;
    }


    public static class Builder {

        private long id;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private Integer defaultCity;
        private Integer perimetar;

        public Builder(long id) {
            this.id = id;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setDefaultCity(Integer defaultCity) {
            this.defaultCity = defaultCity;
            return this;
        }

        public Builder setPerimetar(Integer perimetar) {
            this.perimetar = perimetar;
            return this;
        }

        public DBLoggedInUser build() {
            return new DBLoggedInUser(this);
        }


    }


}