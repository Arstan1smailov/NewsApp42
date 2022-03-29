package com.company.Room;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.Entity;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.company.models.News;

@Database(entities = {News.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract NewsDao newsDao();

}
