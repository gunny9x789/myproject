package com.example.myproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.myproject.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import AllListForder.AllItemSellList;
import AllListForder.ItemSaleInDay;
import AllListForder.Object.ItemSell;
import View.CategoryFragment.CategoryFragment;
import View.HomeFragment.HomeFragment;
import View.NewsFeedFragment.NewsFeedFragment;
import View.NotificationFragment.NotificationFragment;
import View.UserFragment.UserFragment;

public class MainActivity extends AppCompatActivity implements ItemSaleInDay, AllItemSellList {
    ActivityMainBinding mainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        getFragment(HomeFragment.newInstance());
        Intent getIntend = getIntent();
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