package com.example.overweights.ui.MainPage.report;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.overweights.databinding.FragmentDataBinding;
import com.example.overweights.databinding.FragmentReportBinding;

public class DataFragment extends Fragment {
    FragmentDataBinding binding;

    public static DataFragment newInstance() {
        return new DataFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDataBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }
}
