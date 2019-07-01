package com.example.pmaproject.database.dao;

import com.example.pmaproject.database.entity.DBItem;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DBItemDao {

    @Query("SELECT * FROM item")
    List<DBItem> getAll();

    @Insert
    void insertUser(DBItem dbItem);

    @Update
    void updateUser(DBItem dbItem);

    @Delete
    void deleteUser(DBItem dbItem);

    @Query("DELETE FROM item")
    void deleteAll();

}
