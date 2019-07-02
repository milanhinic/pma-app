package com.example.pmaproject.database;

import android.content.Context;

import com.example.pmaproject.database.dao.DBCityDao;
import com.example.pmaproject.database.dao.DBItemDao;
import com.example.pmaproject.database.dao.DBLoggedInUserDao;
import com.example.pmaproject.database.dao.DBNotificationDao;
import com.example.pmaproject.database.dao.DBPotentialFavoriteDao;
import com.example.pmaproject.database.dao.DBStoreDao;
import com.example.pmaproject.database.dao.DBUserDao;
import com.example.pmaproject.database.dao.PotentialFavoriteItemDao;
import com.example.pmaproject.database.entity.DBCity;
import com.example.pmaproject.database.entity.DBItem;
import com.example.pmaproject.database.entity.DBLoggedInUser;
import com.example.pmaproject.database.entity.DBNotification;
import com.example.pmaproject.database.entity.DBPotentialFavorite;
import com.example.pmaproject.database.entity.DBStore;
import com.example.pmaproject.database.entity.DBUser;
import com.example.pmaproject.database.entity.PotentialFavoriteItem;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DBUser.class,
                      DBCity.class,
                      DBStore.class,
                      DBItem.class,
                      DBNotification.class,
                      DBPotentialFavorite.class,
                      DBLoggedInUser.class,
                      PotentialFavoriteItem.class
        },
        version = 11,
        exportSchema = false)
public abstract class ApplicationDatabase extends RoomDatabase {

    private static final String DB_NAME = "application_db";
    public static  ApplicationDatabase instance;

    public static synchronized ApplicationDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                                            ApplicationDatabase.class,
                                            DB_NAME).
                                            allowMainThreadQueries().
                                            fallbackToDestructiveMigration()
                                            .build();
        }


        return instance;
    }

    public abstract DBUserDao dbUserDao();

    public abstract DBCityDao dbCityDao();

    public abstract DBStoreDao dbStoreDao();

    public abstract DBItemDao dbItemDao();

    public abstract DBNotificationDao dbNotificationDao();

    public abstract DBPotentialFavoriteDao dbPotentialFavoriteDao();

    public abstract DBLoggedInUserDao dbLoggedInUserDao();

    public abstract PotentialFavoriteItemDao potentialFavoriteItemDao();

}
