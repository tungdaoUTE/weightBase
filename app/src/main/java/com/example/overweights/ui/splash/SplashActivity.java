package com.example.overweights.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.overweights.databinding.ActivitySplashBinding;
import com.example.overweights.ui.intro.IntroActivity;

public class SplashActivity extends AppCompatActivity {
    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        final Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);

                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    startActivity(new Intent(SplashActivity.this, IntroActivity.class));
                }
            }
        };
        thread.start();
    }
}