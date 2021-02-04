package com.example.overweights.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.overweights.data.model.request.LoginRequest;
import com.example.overweights.data.model.response.TokenResponse;
import com.example.overweights.databinding.ActivityLoginBinding;
import com.example.overweights.utils.Commons;
import com.example.overweights.viewModel.loginViewModel;


public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    loginViewModel mloginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        mloginViewModel = new ViewModelProvider(this).get(loginViewModel.class);

        LoginRequest request = new LoginRequest("admin", "admin", false);
        mloginViewModel.postLogin(request).observe(this, new Observer<TokenResponse>() {
            @Override
            public void onChanged(TokenResponse tokenResponse) {
                Commons.tokenString ="Bearer " +tokenResponse.getIdToken();
            }
        });

    }



}