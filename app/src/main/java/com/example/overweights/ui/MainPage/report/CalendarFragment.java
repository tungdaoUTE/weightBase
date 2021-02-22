package com.example.overweights.ui.MainPage.report;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.overweights.databinding.FragmentCalendarBinding;
import com.example.overweights.databinding.FragmentReportBinding;

public class CalendarFragment extends Fragment {
    public static CalendarFragment newInstance() {
        return new CalendarFragment();
    }

    FragmentCalendarBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCalendarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }
}
