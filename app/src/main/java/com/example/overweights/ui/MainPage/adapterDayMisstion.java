package com.example.overweights.ui.MainPage;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.overweights.R;
import com.example.overweights.data.model.data.DayMission;
import com.example.overweights.databinding.ItemDayBinding;

import java.util.List;

public class adapterDayMisstion extends RecyclerView.Adapter<adapterDayMisstion.ViewHolder> {
    List<DayMission> list;
    Context context;
    onEventDayAdapter monEvent;

    public adapterDayMisstion(List<DayMission> list, Context context, onEventDayAdapter monEvent) {
        this.list = list;
        this.context = context;
        this.monEvent = monEvent;
    }

    @NonNull
    @Override
    public adapterDayMisstion.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        return new ViewHolder(ItemDayBinding.inflate(layoutInflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull adapterDayMisstion.ViewHolder holder, int position) {
        // holder.itemCartBinding.imageItemCart.setText(""+list.get(position).getName());
        holder.itemDayBinding.txtday.setText("DAY "+list.get(position).getDay());
        holder.itemDayBinding.txtEx.setText(list.get(position).getEx()+" Exercises");

        if(list.get(position).isStatus()==true){ // đã hoàn thành
            holder.itemDayBinding.contrainLayout.setBackgroundColor(Color.parseColor("#FA8344"));
            holder.itemDayBinding.imgStatus.setImageResource(R.drawable.daystatusdone);
        }else{
            holder.itemDayBinding.imgStatus.setImageResource(R.drawable.daystatustoday);
            holder.itemDayBinding.contrainLayout.setBackgroundColor(Color.parseColor("#1D202E"));
        }


        holder.itemDayBinding.contrainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monEvent.onClickItem(list.get(position),position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemDayBinding itemDayBinding;

        public ViewHolder(@NonNull ItemDayBinding itemDayBinding) {
            super(itemDayBinding.getRoot());
            this.itemDayBinding = itemDayBinding;
        }
    }
}
