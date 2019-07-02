package com.example.pmaproject.database.dao;

import com.example.pmaproject.database.entity.DBPotentialFavorite;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DBPotentialFavoriteDao {

    @Query("SELECT * FROM potentialFavourite")
    List<DBPotentialFavorite> getAll();

    @Insert
    void insertPotentialFavorite(DBPotentialFavorite dbPotentialFavorite);

    @Update
    void updatePotentialFavorite(DBPotentialFavorite dbPotentialFavorite);

    @Delete
    void deletePotentialFavorite(DBPotentialFavorite dbPotentialFavorite);

    @Query("DELETE FROM potentialFavourite")
    void deleteAll();
}
