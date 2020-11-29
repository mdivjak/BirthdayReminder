package com.mdivjak.bdayapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.mdivjak.bdayapp.databinding.ActivityListBirthdaysBinding;
import com.mdivjak.bdayapp.viewModels.BirthdayViewModel;
import com.mdivjak.bdayapp.viewModels.Injection;

public class ListBirthdaysActivity extends AppCompatActivity {
    private ActivityListBirthdaysBinding binding;
    private BirthdayViewModel birthdayViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBirthdaysBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        birthdayViewModel = new ViewModelProvider(this, Injection.provideBirthdayViewModelFactory(this)).get(BirthdayViewModel.class);
        BirthdayAdapter bdayAdapter = new BirthdayAdapter(this, birthdayViewModel);

        binding.birthdaysList.setHasFixedSize(true);
        binding.birthdaysList.setAdapter(bdayAdapter);
        binding.birthdaysList.setLayoutManager((new LinearLayoutManager(this)));
    }
}