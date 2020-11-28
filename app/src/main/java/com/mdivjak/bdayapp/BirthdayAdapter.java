package com.mdivjak.bdayapp;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.mdivjak.bdayapp.databinding.ViewHolderBirthdayBinding;

import java.util.List;

public class BirthdayAdapter extends RecyclerView.Adapter<BirthdayAdapter.BirthdayViewHolder> {
    private final ListBirthdaysActivity mainActivity;
    private AppDatabase db;

    public BirthdayAdapter(ListBirthdaysActivity mainActivity) {
        this.mainActivity = mainActivity;
        db = Room.databaseBuilder(mainActivity.getApplicationContext(), AppDatabase.class, "birthdays.db").allowMainThreadQueries().build();
    }

    @NonNull
    @Override
    public BirthdayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewHolderBirthdayBinding binding = ViewHolderBirthdayBinding.inflate(
                layoutInflater,
                parent,
                false);
        return new BirthdayViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BirthdayViewHolder holder, int position) {
        Birthday bday = db.birthdayDao().getAll().get(position);
        holder.binding.firstName.setText(bday.firstName);
        holder.binding.lastName.setText(bday.lastName);
        holder.binding.birthday.setText(bday.birthday);
        holder.binding.deleteBirthday.setOnClickListener(view -> {
            db.birthdayDao().deleteBirthday(bday.uid);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return db.birthdayDao().getAll().size();
    }

    public class BirthdayViewHolder extends RecyclerView.ViewHolder {
        private ViewHolderBirthdayBinding binding;

        public BirthdayViewHolder(@NonNull ViewHolderBirthdayBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;

        }
    }
}
