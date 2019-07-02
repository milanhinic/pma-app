package com.example.pmaproject.database.dao;

import com.example.pmaproject.database.entity.DBNotification;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DBNotificationDao {

    @Query("SELECT * FROM notification")
    List<DBNotification> getAll();

    @Insert
    void insertNotification(DBNotification dbNotification);

    @Update
    void updateNotification(DBNotification dbNotification);

    @Delete
    void deleteNotification(DBNotification dbNotification);

    @Query("DELETE FROM notification")
    void deleteAll();

}
