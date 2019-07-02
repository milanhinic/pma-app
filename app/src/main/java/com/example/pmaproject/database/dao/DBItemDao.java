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
    void insertItem(DBItem dbItem);

    @Update
    void updateItem(DBItem dbItem);

    @Delete
    void deleteItem(DBItem dbItem);

    @Query("DELETE FROM item")
    void deleteAll();

}
