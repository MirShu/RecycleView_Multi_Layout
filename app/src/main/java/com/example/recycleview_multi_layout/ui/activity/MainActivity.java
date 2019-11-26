package com.example.recycleview_multi_layout.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.recycleview_multi_layout.model.ResultModel;
import com.example.recycleview_multi_layout.R;
import com.example.recycleview_multi_layout.adapter.Adapter;
import com.example.recycleview_multi_layout.ui.fragment.NavigationFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{


    private NavigationFragment mNavigationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCurrentFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (mNavigationFragment == null) {
            mNavigationFragment = NavigationFragment.newInstance(getString(R.string.navigation_navigation_bar));
        }
        transaction.replace(R.id.frame_content, mNavigationFragment);

    }

    private void setCurrentFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        mNavigationFragment = NavigationFragment.newInstance(getString(R.string.navigation_navigation_bar));
        transaction.replace(R.id.frame_content, mNavigationFragment).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()) {
        }
        transaction.commit();
        return true;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}
