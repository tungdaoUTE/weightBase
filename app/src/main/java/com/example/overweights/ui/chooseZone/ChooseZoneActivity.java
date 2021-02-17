package com.example.overweights.ui.chooseZone;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.overweights.R;
import com.example.overweights.databinding.ActivityChooseZoneBinding;

public class ChooseZoneActivity extends AppCompatActivity {

    ActivityChooseZoneBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChooseZoneBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

            binding.btnButt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    resetAll();
                    binding.imgChoose.setImageResource(R.drawable.imgbutt);
                    binding.btnButt.setTextColor(Color.parseColor("#FA8344"));
                    binding.btnButt.setBackgroundResource(R.drawable.bg_button_select);
                }
            });

        binding.btnAbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAll();
                binding.imgChoose.setImageResource(R.drawable.imgabs);
                binding.btnAbs.setTextColor(Color.parseColor("#FA8344"));
                binding.btnAbs.setBackgroundResource(R.drawable.bg_button_select);
            }
        });

        binding.btnLeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAll();
                binding.imgChoose.setImageResource(R.drawable.imgleg);
                binding.btnLeg.setTextColor(Color.parseColor("#FA8344"));
                binding.btnLeg.setBackgroundResource(R.drawable.bg_button_select);
            }
        });

        binding.btnArm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAll();
                binding.imgChoose.setImageResource(R.drawable.imgarm);
                binding.btnArm.setTextColor(Color.parseColor("#FA8344"));
                binding.btnArm.setBackgroundResource(R.drawable.bg_button_select);
            }
        });

    }

    public void resetAll(){
        binding.imgChoose.setImageResource(R.drawable.imgdefault);

        binding.btnButt.setTextColor(Color.parseColor("#C3C7DB"));
        binding.btnButt.setBackgroundResource(R.drawable.bg_button);

        binding.btnAbs.setTextColor(Color.parseColor("#C3C7DB"));
        binding.btnAbs.setBackgroundResource(R.drawable.bg_button);

        binding.btnArm.setTextColor(Color.parseColor("#C3C7DB"));
        binding.btnArm.setBackgroundResource(R.drawable.bg_button);

        binding.btnLeg.setTextColor(Color.parseColor("#C3C7DB"));
        binding.btnLeg.setBackgroundResource(R.drawable.bg_button);

    }
}