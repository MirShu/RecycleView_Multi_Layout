package com.example.recycleview_multi_layout.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.recycleview_multi_layout.R;
import com.example.recycleview_multi_layout.base.Api;
import com.example.recycleview_multi_layout.model.NewsModel;
import com.example.recycleview_multi_layout.ui.fragment.main_fragment.NavigationFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

import org.xutils.http.RequestParams;
import org.xutils.x;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
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
