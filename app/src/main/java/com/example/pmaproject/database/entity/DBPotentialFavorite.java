package com.example.pmaproject.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "potentialFavourite")
public class DBPotentialFavorite {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "User Id")
    private Integer userId;

    @ColumnInfo(name = "Store Id")
    private Integer storeId;

    @ColumnInfo(name = "Counter")
    private long counter;

    public DBPotentialFavorite() {
    }

    public DBPotentialFavorite(DBPotentialFavorite.Builder builder) {
        id = builder.id;
        userId = builder.userId;
        storeId = builder.storeId;
        counter = builder.counter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public static class Builder {
        private long id;
        private Integer userId;
        private Integer storeId;
        private long counter;

        public Builder(long id) {
            this.id = id;
        }

        public Builder setUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder setStoreId(Integer storeId) {
            this.storeId = storeId;
            return this;
        }

        public Builder setCounter(long counter) {
            this.counter = counter;
            return this;
        }

        public DBPotentialFavorite build() {
            return new DBPotentialFavorite(this);
        }

    }


}
