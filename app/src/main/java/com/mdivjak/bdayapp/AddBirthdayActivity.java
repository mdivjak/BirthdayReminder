package com.mdivjak.bdayapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.os.Bundle;

import com.mdivjak.bdayapp.databinding.ActivityAddBirthdayBinding;
import com.mdivjak.bdayapp.db.BirthdayDatabase;
import com.mdivjak.bdayapp.db.Birthday;
import com.mdivjak.bdayapp.viewModels.BirthdayViewModel;
import com.mdivjak.bdayapp.viewModels.Injection;

public class AddBirthdayActivity extends AppCompatActivity {
    private ActivityAddBirthdayBinding binding;
    private BirthdayViewModel birthdayViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddBirthdayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        birthdayViewModel = new ViewModelProvider(this, Injection.provideBirthdayViewModelFactory(this)).get(BirthdayViewModel.class);

        binding.addBdayButton.setOnClickListener(view -> {
            Birthday bday = new Birthday();
            bday.firstName = binding.firstname.getEditText().getText().toString();
            bday.lastName = binding.lastname.getEditText().getText().toString();
            bday.birthday = binding.birthday.getText().toString();

            birthdayViewModel.insertBirthday(bday);
        });

    }
}