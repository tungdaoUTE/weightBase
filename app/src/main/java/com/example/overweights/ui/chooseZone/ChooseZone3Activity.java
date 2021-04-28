package com.example.overweights.ui.chooseZone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.overweights.databinding.ActivityChooseZone3Binding;

public class ChooseZone3Activity extends AppCompatActivity {
    ActivityChooseZone3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.overweights.databinding.ActivityChooseZone3Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}