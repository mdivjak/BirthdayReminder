package com.mdivjak.bdayapp.viewModels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.mdivjak.bdayapp.BirthdayRepository;

public class BirthdayViewModelFactory implements ViewModelProvider.Factory {
    private final BirthdayRepository birthdayRepository;

    public BirthdayViewModelFactory(BirthdayRepository birthdayRepository) {
        this.birthdayRepository = birthdayRepository;
    }

    @Override
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(BirthdayViewModel.class)) {
            return (T) new BirthdayViewModel(birthdayRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
