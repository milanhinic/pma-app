package com.example.pmaproject.database.dao;

import com.example.pmaproject.database.entity.DBStore;

import java.util.ArrayList;
import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DBStoreDao {

    @Query("SELECT * FROM store")
    List<DBStore> getAll();

    @Query("SELECT store.Name FROM store WHERE store.`City Id` = :cityId")
    List<String> getAllStoreNames(Integer cityId);

    @Query("SELECT * FROM store WHERE store.`City Id` = :cityId")
    List<DBStore> getAllStores(Integer cityId);

    @Insert
    void insertStore(DBStore dbStore);

    @Update
    void updateStore(DBStore dbStore);

    @Delete
    void deleteStore(DBStore dbStore);

    @Query("DELETE FROM store")
    void deleteAll();
}
