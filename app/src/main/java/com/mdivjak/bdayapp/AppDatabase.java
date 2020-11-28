package com.mdivjak.bdayapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Birthday.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BirthdayDao birthdayDao();
}
