package com.example.pmaproject.database.dao;

import com.example.pmaproject.database.entity.PotentialFavoriteItem;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface PotentialFavoriteItemDao {

    @Query("SELECT * FROM potentialFavouriteItem")
    List<PotentialFavoriteItem> getAll();

    @Insert
    void insertUser(PotentialFavoriteItem potentialFavoriteItem);

    @Update
    void updateUser(PotentialFavoriteItem potentialFavoriteItem);

    @Delete
    void deleteUser(PotentialFavoriteItem potentialFavoriteItem);

    @Query("DELETE FROM potentialFavouriteItem")
    void deleteAll();

}
