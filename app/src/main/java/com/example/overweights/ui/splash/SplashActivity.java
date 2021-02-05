package com.example.overweights.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import com.example.overweights.databinding.ActivitySplashBinding;
import com.example.overweights.ui.intro.IntroActivity;
import com.example.overweights.ui.login.LoginActivity;
import com.example.overweights.utils.SharedPref;

import static java.lang.Thread.sleep;

public class SplashActivity extends AppCompatActivity {
    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences getpre = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                boolean isfirtstart = getpre.getBoolean("firststart", true);
                try {
                    sleep(2000);
                    if (isfirtstart) {
                        startActivity(new Intent(SplashActivity.this, IntroActivity.class));
                        SharedPreferences.Editor e = getpre.edit();
                        e.putBoolean("firststart", false);
                        e.apply();
                    } else {
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        thread.start();
    }
}