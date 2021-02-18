package com.example.overweights.ui.chooseZone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.overweights.R;
import com.example.overweights.databinding.ActivityChooseZone2Binding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChooseZone2Activity extends AppCompatActivity {
    ActivityChooseZone2Binding binding;
    List<String> mapHeight_cm = new ArrayList<>();
    List<String> mapCurentWeight_kg = new ArrayList<>();
    List<String> mapTargetWeight_kg = new ArrayList<>();

    List<String> mapHeight_ft = new ArrayList<>();
    List<String> mapCurentWeight_ib = new ArrayList<>();
    List<String> mapTargetWeight_ib = new ArrayList<>();

    ArrayAdapter<String> adapterHeight_cm;
    ArrayAdapter<String> adapterCurentWeight_kg;
    ArrayAdapter<String> adapterTargetWeight_kg;

    ArrayAdapter<String> adapterHeight_ft;
    ArrayAdapter<String> adapterCurentWeight_ib;
    ArrayAdapter<String> adapterTargetWeight_ib;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChooseZone2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        createData();

        binding.btnkgCm.setTextColor(Color.parseColor("#FFFFFF"));
        binding.btnkgCm.setBackgroundResource(R.drawable.bg_button_select_2);
        binding.spHeight.setAdapter(adapterHeight_cm);
        binding.sptargetWeight.setAdapter(adapterTargetWeight_kg);
        binding.spWeight.setAdapter(adapterCurentWeight_kg);

        buttonEvent();


    }

    private void createData() {
        for (int i = 0; i < 200; i++) {
            mapHeight_cm.add(i + " cm");
            mapCurentWeight_kg.add( i + " kg");
            mapTargetWeight_kg.add(i + " kg");

            mapHeight_ft.add(i + " ft");
            mapCurentWeight_ib.add( i + " ib");
            mapTargetWeight_ib.add(i + " ib");

            adapterHeight_cm = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mapHeight_cm);
            adapterCurentWeight_kg = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mapCurentWeight_kg);
            adapterTargetWeight_kg = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mapTargetWeight_kg);

            adapterHeight_ft = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mapHeight_ft);
            adapterCurentWeight_ib = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mapCurentWeight_ib);
            adapterTargetWeight_ib = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mapTargetWeight_ib);



        }
    }

    private void buttonEvent() {
        binding.btnibFt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAll();
                binding.btnibFt.setTextColor(Color.parseColor("#FFFFFF"));
                binding.btnibFt.setBackgroundResource(R.drawable.bg_button_select_2);

                binding.spHeight.setAdapter(adapterHeight_ft);
                binding.sptargetWeight.setAdapter(adapterTargetWeight_ib);
                binding.spWeight.setAdapter(adapterCurentWeight_ib);
            }
        });

        binding.btnkgCm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAll();
                binding.btnkgCm.setTextColor(Color.parseColor("#FFFFFF"));
                binding.btnkgCm.setBackgroundResource(R.drawable.bg_button_select_2);

                binding.spHeight.setAdapter(adapterHeight_cm);
                binding.sptargetWeight.setAdapter(adapterTargetWeight_kg);
                binding.spWeight.setAdapter(adapterCurentWeight_kg);
            }
        });

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseZone2Activity.this, ChooseZoneActivity.class));
            }
        });
    }

    public void resetAll() {

        binding.btnkgCm.setTextColor(Color.parseColor("#C3C7DB"));
        binding.btnkgCm.setBackgroundResource(R.drawable.bg_button);

        binding.btnibFt.setTextColor(Color.parseColor("#C3C7DB"));
        binding.btnibFt.setBackgroundResource(R.drawable.bg_button);

    }
}