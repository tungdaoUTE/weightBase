package com.example.overweights.ui.MainPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.fragment.app.Fragment;

import com.example.overweights.databinding.FragmentDiscoverBinding;
import com.example.overweights.databinding.FragmentPlanBinding;

public class DiscoverFragment extends Fragment {

    FragmentDiscoverBinding binding;

    public DiscoverFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDiscoverBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }
}
