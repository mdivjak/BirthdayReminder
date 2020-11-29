package com.mdivjak.bdayapp.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mdivjak.bdayapp.db.Birthday;
import com.mdivjak.bdayapp.db.BirthdayDao;

@Database(entities = {Birthday.class}, version = 1, exportSchema = false)
public abstract class BirthdayDatabase extends RoomDatabase {
    public abstract BirthdayDao birthdayDao();
    private static BirthdayDatabase _instance;

    public static BirthdayDatabase getInstance(Context context) {
        if(_instance == null) {
            synchronized (BirthdayDatabase.class) {
                if(_instance == null) {
                    _instance = Room.databaseBuilder(context.getApplicationContext(),
                            BirthdayDatabase.class,
                            "birthdays.db").allowMainThreadQueries().build();
                }
            }
        }
        return _instance;
    }

}
