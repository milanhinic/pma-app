package com.example.pmaproject.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class DBUser {

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

    @ColumnInfo(name = "LoggedIn")
    public boolean loggedIn;

    @ColumnInfo(name = "Favorites")
    private String favorites;


    public DBUser() {}

    public DBUser(DBUser.Builder builder) {
        id = builder.id;
        firstName = builder.firstName;
        lastName = builder.lastName;
        email = builder.email;
        password = builder.password;
        defaultCity = builder.defaultCity;
        perimetar = builder.perimetar;
        loggedIn = builder.loggedIn;
        favorites = builder.favorites;

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

    public boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }

    public static class Builder {

        private long id;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private Integer defaultCity;
        private Integer perimetar;
        public boolean loggedIn;
        public  String favorites;

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

        public Builder setLoggedIn(boolean loggedIn) {
            this.loggedIn = loggedIn;
            return this;
        }

        public Builder setfavorites(String favorites) {
            this.favorites = favorites;
            return this;
        }

        public DBUser build() {
            DBUser user = new DBUser();
            user.firstName = this.firstName;
            user.lastName = this.lastName;
            user.email = this.email;
            user.password = this.password;
            user.defaultCity = this.defaultCity;
            user.perimetar = this.perimetar;
            user.loggedIn = loggedIn;
            user.favorites = favorites;
            return user;
        }

    }
}
