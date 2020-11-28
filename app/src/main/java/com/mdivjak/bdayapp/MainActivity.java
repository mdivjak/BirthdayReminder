package com.mdivjak.bdayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.mdivjak.bdayapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addBday.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(this, AddBirthdayActivity.class);
            startActivity(intent);
        });

        binding.listBdays.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(this, ListBirthdaysActivity.class);
            startActivity(intent);
        });
    }
}