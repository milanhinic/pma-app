package com.example.pmaproject.database.dao;

import com.example.pmaproject.database.entity.DBUser;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DBUserDao {

    @Query("SELECT * FROM users")
    List<DBUser> getAll();

    @Insert
    void insertUser(DBUser dbUser);

    @Update
    void updateUser(DBUser dbUser);

    @Delete
    void deleteUser(DBUser dbUser);

    @Query("DELETE FROM users")
    void deleteAll();
}
