package com.example.myproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.myproject.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import AllListForder.MainCategoryList;
import FunctionFragment.CategoryFragment.CategoryFragment;
import FunctionFragment.HomeFragment.HomeFragment;
import FunctionFragment.NewsFeedFragment.NewsFeedFragment;
import FunctionFragment.NotificationFragment.NotificationFragment;
import FunctionFragment.UserFragment.UserFragment;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        getFragment(HomeFragment.newInstance());
        Intent getIntend = getIntent();
        String json = getIntend.getStringExtra("Json");
        Boolean checkInternet = getIntend.getBooleanExtra("CheckInternet",true);
        if (checkInternet == false){
            Toast.makeText(this,"Kiem tra lai ket noi", Toast.LENGTH_LONG).show();
        }
        mainBinding.mainFunctionBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.function_home: {
                        mainBinding.mainSearchBar.setVisibility(View.VISIBLE);
                        Toast.makeText(getBaseContext(),json,Toast.LENGTH_SHORT).show();
                        getFragment(HomeFragment.newInstance());
                        break;
                    }
                    case R.id.function_category: {
                        mainBinding.mainSearchBar.setVisibility(View.VISIBLE);
                        getFragment(CategoryFragment.newInstance());
                        break;
                    }
                    case R.id.function_News: {
                        mainBinding.mainSearchBar.setVisibility(View.GONE);
                        getFragment(NewsFeedFragment.newInstance());
                        break;
                    }
                    case R.id.function_Notification: {
                        mainBinding.mainSearchBar.setVisibility(View.GONE);
                        getFragment(NotificationFragment.newInstance());
                        break;
                    }
                    case R.id.function_User: {
                        mainBinding.mainSearchBar.setVisibility(View.GONE);
                        getFragment(UserFragment.newInstance());
                        break;
                    }
                    default:
                        break;
                }
                return true;
            }
        });

    }

    public void getFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment).commit();
    }

}