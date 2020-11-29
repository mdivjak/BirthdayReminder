package com.mdivjak.bdayapp.viewModels;

import androidx.lifecycle.ViewModel;

import com.mdivjak.bdayapp.BirthdayRepository;
import com.mdivjak.bdayapp.db.Birthday;

import java.util.List;

public class BirthdayViewModel extends ViewModel {
    private final BirthdayRepository birthdayRepository;

    public BirthdayViewModel(BirthdayRepository birthdayRepository) {
        this.birthdayRepository = birthdayRepository;
    }

    public List<Birthday> getAllBirthdays() {
        return birthdayRepository.getAllBirthdays();
    }

    public void insertBirthday(Birthday b) {
        birthdayRepository.insertBirthday(b);
    }

    public void deleteBirthday(Integer uid) {
        birthdayRepository.deleteBirthday(uid);
    }
}
