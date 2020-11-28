package com.mdivjak.bdayapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.mdivjak.bdayapp.databinding.ActivityAddBirthdayBinding;

public class AddBirthdayActivity extends AppCompatActivity {
    private ActivityAddBirthdayBinding binding;
    private AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddBirthdayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "birthdays.db").allowMainThreadQueries().build();

        binding.addBdayButton.setOnClickListener(view -> {
            Birthday bday = new Birthday();
            bday.firstName = binding.firstname.getEditText().getText().toString();
            bday.lastName = binding.lastname.getEditText().getText().toString();
            bday.birthday = binding.birthday.getText().toString();

            db.birthdayDao().insertBirthday(bday);
        });

    }
}