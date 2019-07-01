package com.example.pmaproject.database.dao;

import com.example.pmaproject.database.entity.DBCity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DBCityDao {

    @Query("SELECT * FROM city")
    List<DBCity> getAll();

    @Insert
    void insertUser(DBCity dbCity);

    @Update
    void updateUser(DBCity dbCity);

    @Delete
    void deleteUser(DBCity dbCity);

    @Query("DELETE FROM city")
    void deleteAll();

}
