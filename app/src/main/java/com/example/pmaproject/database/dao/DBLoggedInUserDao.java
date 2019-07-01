package com.example.pmaproject.database.dao;

import com.example.pmaproject.database.entity.DBLoggedInUser;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DBLoggedInUserDao {

    @Query("SELECT * FROM loggedInUser")
    List<DBLoggedInUser> getAll();

    @Insert
    void insertUser(DBLoggedInUser dbLoggedInUser);

    @Update
    void updateUser(DBLoggedInUser dbLoggedInUser);

    @Delete
    void deleteUser(DBLoggedInUser dbLoggedInUser);

    @Query("DELETE FROM loggedInUser")
    void deleteAll();

}
