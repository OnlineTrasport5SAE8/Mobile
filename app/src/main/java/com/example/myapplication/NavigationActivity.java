package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.navigation); // Update the layout file name here

        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(item -> {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        HomeFragment homeFragment = new HomeFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_containerH, homeFragment)
                                .commit();
                        return true;

                    case R.id.nav_share:
                        ShareFragment shareFragment = new ShareFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_containerSA, shareFragment)
                                .commit();
                        return true;

                    case R.id.nav_settings:
                        SettingsFragment settingsFragment = new SettingsFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_containerSE, settingsFragment)
                                .commit();
                        return true;

                    case R.id.nav_about:
                        AboutFragment aboutFragment = new AboutFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_containerA, aboutFragment)
                                .commit();
                        return true;
                    case R.id.nav_blog:
                        BlogFragment blogFragment = new BlogFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_containerBl, blogFragment)
                                .commit();
                        return true;
                }
                return false;
            });

        // Set the initial fragment
        loadFragment(new HomeFragment());
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_containerH, fragment)
                .commit();
    }
}