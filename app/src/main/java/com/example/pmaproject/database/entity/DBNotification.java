package com.example.pmaproject.database.entity;

import java.security.PublicKey;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notification")
public class DBNotification {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "Store Id")
    private Integer storeId;

    @ColumnInfo(name = "User Id")
    private Integer userId;

    @ColumnInfo(name = "Date")
    private String date;

    @ColumnInfo(name = "Content")
    private String content;

    public DBNotification() {
    }

    public DBNotification(DBNotification.Builder builder) {
        id = builder.id;
        storeId = builder.storeId;
        userId = builder.userId;
        date = builder.date;
        content = builder.content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static class Builder {
        private long id;
        private Integer storeId;
        private Integer userId;
        private String date;
        private String content;

        public Builder(long id) {
            this.id = id;
        }

        public Builder setStoreId(Integer storeId) {
            this.storeId = storeId;
            return this;
        }

        public Builder setUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public DBNotification build() {
            DBNotification notification = new DBNotification();
            notification.storeId = storeId;
            notification.userId = userId;
            notification.date = date;
            notification.content = content;
            return notification;
        }

    }

}
