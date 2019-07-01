package com.example.pmaproject.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "item")
public class DBItem {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "Name")
    private String name;

    @ColumnInfo(name = "Discount")
    private Integer discount;

    @ColumnInfo(name = "Price")
    private double price;

    @ColumnInfo(name = "From date")
    private String fromDate;

    @ColumnInfo(name = "To date")
    private String toDate;

    @ColumnInfo(name = "Store Id")
    private Integer storeId;

    public DBItem() {
    }

    public DBItem(DBItem.Builder builder) {
        id = builder.id;
        name = builder.name;
        discount = builder.discount;
        price = builder.price;
        fromDate = builder.fromDate;
        toDate = builder.toDate;
        storeId = builder.storeId;
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

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public static class Builder {
        private long id;
        private String name;
        private Integer discount;
        private double price;
        private String fromDate;
        private String toDate;
        private Integer storeId;

        public Builder(long id) {
            this.id = id;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDiscount(Integer discount) {
            this.discount = discount;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setFromDate(String fromDate) {
            this.fromDate = fromDate;
            return this;
        }

        public Builder setToDate(String toDate) {
            this.toDate = toDate;
            return this;
        }

        public Builder setStoreId(Integer storeId) {
            this.storeId = storeId;
            return this;
        }

        public DBItem build() {
            DBItem item = new DBItem();
            item.name = this.name;
            item.discount = this.discount;
            item.price = this.price;
            item.fromDate = this.fromDate;
            item.toDate = this.toDate;
            item.storeId = this.storeId;
            return item;
        }


    }


}


