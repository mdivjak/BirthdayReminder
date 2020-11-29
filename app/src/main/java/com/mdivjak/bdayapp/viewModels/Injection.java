package com.mdivjak.bdayapp.viewModels;

import android.content.Context;

import com.mdivjak.bdayapp.BirthdayRepository;
import com.mdivjak.bdayapp.db.BirthdayDatabase;

public class Injection {
    public static BirthdayRepository provideBirthdayRepository(Context context) {
        BirthdayDatabase database = BirthdayDatabase.getInstance(context);
        return new BirthdayRepository(database.birthdayDao());
    }

    public static BirthdayViewModelFactory provideBirthdayViewModelFactory(Context context) {
        BirthdayRepository birthdayRepository = provideBirthdayRepository(context);
        return new BirthdayViewModelFactory(birthdayRepository);
    }
}
