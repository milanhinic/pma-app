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

    @Query("SELECT city.Name FROM city")
    List<String> getAllCitiesNames();

    @Query("SELECT * FROM city WHERE city.id = :id")
    DBCity getById(long id);

    @Insert
    void insertCity(DBCity dbCity);

    @Update
    void updateCity(DBCity dbCity);

    @Delete
    void deleteCity(DBCity dbCity);

    @Query("DELETE FROM city")
    void deleteAll();

}
