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
    void insertPotentialFavoriteItem(PotentialFavoriteItem potentialFavoriteItem);

    @Update
    void updatePotentialFavoriteItem(PotentialFavoriteItem potentialFavoriteItem);

    @Delete
    void deletePotentialFavoriteItem(PotentialFavoriteItem potentialFavoriteItem);

    @Query("DELETE FROM potentialFavouriteItem")
    void deleteAll();

}
