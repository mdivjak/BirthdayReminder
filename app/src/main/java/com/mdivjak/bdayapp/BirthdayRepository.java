package com.mdivjak.bdayapp;

import com.mdivjak.bdayapp.db.Birthday;
import com.mdivjak.bdayapp.db.BirthdayDao;

import java.util.List;
import java.util.concurrent.Executors;

public class BirthdayRepository {
    private BirthdayDao birthdayDao;

    public BirthdayRepository(BirthdayDao birthdayDao) {
        this.birthdayDao = birthdayDao;
    }

    public List<Birthday> getAllBirthdays() {
        return birthdayDao.getAllBirthdays();
    }

    public void insertBirthday(Birthday b) {
        Executors.newSingleThreadExecutor().execute(() -> {
            birthdayDao.insertBirthday(b);
        });
    }

    public void deleteBirthday(Integer uid) {
        Executors.newSingleThreadExecutor().execute(() -> {
            birthdayDao.deleteBirthday(uid);
        });
    }
}
