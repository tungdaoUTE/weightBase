package com.example.overweights.ui.intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.overweights.R;
import com.example.overweights.databinding.ActivityIntroBinding;
import com.example.overweights.databinding.ActivityLoginBinding;
import com.example.overweights.ui.chooseZone.ChooseZoneActivity;

public class IntroActivity extends AppCompatActivity {
    ActivityIntroBinding binding;

    public int[] slide_images = {R.mipmap.slide1, R.mipmap.slide2, R.mipmap.slide3};
    public String[] slideHeading = {
            "Lost weight fast",
            "Personalized plan",
            "Diet plan"
    };
    public String[] slideAbout = {
            "Only about 10 to 20 minutes per day, continuously for 30 days. You see quick body change",
            "Focus on your trouble zone. Personalize you training plan based on your time and fitness level and increase workout result by 25%",
            "Diet and exercise are most effective when done together as compared to either strategy alone"
    };

    private TextView[] mdots;
    int position = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        addDotssIndicator(position);
        binding.imgSlide.setImageResource(slide_images[position]);
        binding.txtheading.setText(slideHeading[position]);
        binding.txtAbout.setText(slideAbout[position]);
        binding.imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                if(position>2){
                    SharedPreferences getpre= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    boolean isfirtstart=getpre.getBoolean("firststart",true);
                    SharedPreferences.Editor e=getpre.edit();
                    e.putBoolean("firststart",false);
                    e.apply();
                    startActivity(new Intent(IntroActivity.this, ChooseZoneActivity.class));
                }else{
                    addDotssIndicator(position);
                    binding.imgSlide.setImageResource(slide_images[position]);
                    binding.txtheading.setText(slideHeading[position]);
                    binding.txtAbout.setText(slideAbout[position]);
                }

            }
        });

        binding.txtSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences getpre= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                boolean isfirtstart=getpre.getBoolean("firststart",true);
                SharedPreferences.Editor e=getpre.edit();
                e.putBoolean("firststart",false);
                e.apply();
                startActivity(new Intent(IntroActivity.this, ChooseZoneActivity.class));
            }
        });

    }

    public void addDotssIndicator(int position){
        binding.slidelayout.removeAllViewsInLayout();
        mdots = new TextView[slideHeading.length];
        for(int i=0;i<mdots.length;i++){
            mdots[i] = new TextView(this);
            mdots[i].setText(Html.fromHtml("&#8226"));
            mdots[i].setTextSize(35);
            mdots[i].setTextColor(getResources().getColor(R.color.white));
            binding.slidelayout.addView(mdots[i]);
        }
        if(mdots.length>0){
            mdots[position].setTextColor(getResources().getColor(R.color.design_default_color_primary));
        }
    }
}