package com.mdivjak.bdayapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.mdivjak.bdayapp.databinding.ActivityListBirthdaysBinding;

public class ListBirthdaysActivity extends AppCompatActivity {
    private ActivityListBirthdaysBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBirthdaysBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BirthdayAdapter bdayAdapter = new BirthdayAdapter(this);

        binding.birthdaysList.setHasFixedSize(true);
        binding.birthdaysList.setAdapter(bdayAdapter);
        binding.birthdaysList.setLayoutManager((new LinearLayoutManager(this)));
    }
}