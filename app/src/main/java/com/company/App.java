package com.company;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;

import com.company.Room.AppDataBase;

public class App extends Application {

    private static AppDataBase dataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        dataBase = Room
                .databaseBuilder(this, AppDataBase.class, "database").fallbackToDestructiveMigration()
                .allowMainThreadQueries().build();

    }

    public static AppDataBase getDataBase() {
        return dataBase;
    }
}
