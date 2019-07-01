package com.example.pmaproject.database.dao;

import com.example.pmaproject.database.entity.DBStore;

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

    @Insert
    void insertUser(DBStore dbStore);

    @Update
    void updateUser(DBStore dbStore);

    @Delete
    void deleteUser(DBStore dbStore);

    @Query("DELETE FROM store")
    void deleteAll();
}
