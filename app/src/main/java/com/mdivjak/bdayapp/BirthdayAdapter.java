package com.mdivjak.bdayapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.mdivjak.bdayapp.databinding.ViewHolderBirthdayBinding;
import com.mdivjak.bdayapp.db.BirthdayDatabase;
import com.mdivjak.bdayapp.db.Birthday;
import com.mdivjak.bdayapp.viewModels.BirthdayViewModel;

public class BirthdayAdapter extends RecyclerView.Adapter<BirthdayAdapter.BirthdayViewHolder> {
    private final ListBirthdaysActivity mainActivity;
    private BirthdayViewModel birthdayViewModel;

    public BirthdayAdapter(ListBirthdaysActivity mainActivity, BirthdayViewModel birthdayViewModel) {
        this.mainActivity = mainActivity;
        this.birthdayViewModel = birthdayViewModel;
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
        Birthday bday = birthdayViewModel.getAllBirthdays().get(position);
        holder.binding.firstName.setText(bday.firstName);
        holder.binding.lastName.setText(bday.lastName);
        holder.binding.birthday.setText(bday.birthday);
        holder.binding.deleteBirthday.setOnClickListener(view -> {
            birthdayViewModel.deleteBirthday(bday.uid);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return birthdayViewModel.getAllBirthdays().size();
    }

    public class BirthdayViewHolder extends RecyclerView.ViewHolder {
        private ViewHolderBirthdayBinding binding;

        public BirthdayViewHolder(@NonNull ViewHolderBirthdayBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
