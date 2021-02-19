package com.example.overweights.ui.MainPage;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.overweights.data.model.data.DayMission;
import com.example.overweights.databinding.FragmentPlanBinding;

import java.util.ArrayList;

public class PlanFragment extends Fragment implements onEventDayAdapter {
    FragmentPlanBinding binding;

    ArrayList<DayMission> list = new ArrayList<>();
    adapterDayMisstion adapterDayMisstion;

    public PlanFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPlanBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        // code here
        binding.donutProgress.setDonut_progress("50");
        binding.progressBar3.setProgress(20);
        binding.progressBar3.getProgressDrawable().setColorFilter(Color.parseColor("#FFC700"), android.graphics.PorterDuff.Mode.SRC_IN);

        fakeData();
        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapterDayMisstion = new adapterDayMisstion(list, getContext(), this);
        binding.recyclerview.setAdapter(adapterDayMisstion);

        return root;
    }

    private void fakeData() {
        for (int i = 1; i < 31; i++) {
            if(i%2==0){
                DayMission dayMission = new DayMission(1,""+i,"8",true);
                list.add(dayMission);
            }else {
                DayMission dayMission = new DayMission(1,""+i,"8",false);
                list.add(dayMission);
            }
        }
    }

    @Override
    public void onClickItem(DayMission dayMission, int position) {
        Toast.makeText(getContext(), "" + dayMission.getDay(), Toast.LENGTH_SHORT).show();
    }
}
