package com.mdivjak.bdayapp.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Birthday {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    public String firstName;
    public String lastName;
    public String birthday;
}
