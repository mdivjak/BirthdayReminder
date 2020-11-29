package com.mdivjak.bdayapp.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mdivjak.bdayapp.db.Birthday;

import java.util.List;

@Dao
public interface BirthdayDao {
    @Query("select * from birthday")
    public List<Birthday> getAllBirthdays();

    @Insert
    public void insertBirthday(Birthday birthday);

    @Query("delete from birthday where uid=:uid")
    public void deleteBirthday(int uid);
}
