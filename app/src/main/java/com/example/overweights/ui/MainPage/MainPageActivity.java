package com.example.overweights.ui.MainPage;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.overweights.R;
import com.example.overweights.databinding.ActivityMainPageBinding;
import com.example.overweights.utils.BottomNavigationBehavior;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainPageActivity extends AppCompatActivity {
        ActivityMainPageBinding binding;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainPageBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // attaching bottom sheet behaviour - hide / show on scroll
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) binding.navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        binding.navigation.setSelectedItemId(R.id.nav_plan);

    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.nav_plan:
                    fragment = new PlanFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_discover:
                    fragment = new DiscoverFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_report:
                    Toast.makeText(MainPageActivity.this, "report", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.nav_setting:
                    return true;
            }
            return false;
        }
    };
}