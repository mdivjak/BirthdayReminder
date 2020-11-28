package com.mdivjak.bdayapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BirthdayDao {
    @Query("select * from birthday")
    public List<Birthday> getAll();

    @Insert
    public void insertBirthday(Birthday birthday);

    @Query("delete from birthday where uid=:uid")
    public void deleteBirthday(int uid);
}
