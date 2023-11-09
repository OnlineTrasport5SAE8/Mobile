package com.example.myapplication;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        int iconColor = ContextCompat.getColor(this, R.color.ma_couleur);
        bottomNavigationView.setItemIconTintList(ColorStateList.valueOf(iconColor));

        Drawable bgColor = ContextCompat.getDrawable(this, R.drawable.nav_background_curved);
        int textColor = ContextCompat.getColor(this, R.color.ma_couleur);
        bottomNavigationView.setItemTextColor(ColorStateList.valueOf(textColor));

        bottomNavigationView.setBackground(bgColor);

        bottomNavigationView.setOnItemSelectedListener(item -> {

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        loadFragment(new HomeFragment());
                        return true;
                    case R.id.nav_share:
                        loadFragment(new ShareFragment());
                        return true;
                    case R.id.nav_settings:
                        loadFragment(new SettingsFragment());
                        return true;
                    case R.id.nav_about:
                        loadFragment(new AboutFragment());
                        return true;
                    default:
                        return false;
                }

        });

    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_containerH, fragment)
                .commit();
    }
}