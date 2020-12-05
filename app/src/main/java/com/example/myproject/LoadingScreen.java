package com.example.myproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import AllListForder.MainAdsList;
import AllListForder.MainCategoryList;
import AllListForder.Object.MainCategory;
import FunctionFragment.HomeFragment.HomeFragment;

public class LoadingScreen extends AppCompatActivity implements MainCategoryList {
    private int Request_Permission_Code = 10;
    private String URL_LINK_MAIN_CATEGORY = "https://demo6258945.mockable.io/DemoMainAds";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.INTERNET}, Request_Permission_Code);

        new GetData().execute();
    }

    class GetData extends AsyncTask<Void, Integer, Integer> {
        String mainAdsCategoryJSON = "";
        Intent intent;
        Intent intent1;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            intent = new Intent(getBaseContext(), MainActivity.class);
            intent1 = new Intent(getBaseContext(), HomeFragment.class);
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            try {
                URL url = new URL(URL_LINK_MAIN_CATEGORY);
                URLConnection urlConnection = url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                int count = 0;
                int byteCharacter;
                while ((byteCharacter = inputStream.read()) != -1) {
                    mainAdsCategoryJSON += (char) byteCharacter;
                }
                intent.putExtra("CheckInternet", true);
            } catch (Exception e) {
                intent.putExtra("CheckInternet", false);
                e.printStackTrace();
            }
            MAIN_CATEGORY_LIST.clear();
            MAIN_CATEGORY_LIST.add(new MainCategory(0, "toy_and_mom", getString(R.string.toy_and_mom), R.drawable.toy_and_mom));
            MAIN_CATEGORY_LIST.add(new MainCategory(1, "phone_and_tablet", getString(R.string.phone_and_tablet), R.drawable.phone_and_tablet));
            MAIN_CATEGORY_LIST.add(new MainCategory(2, "cosmetic", getString(R.string.cosmetic), R.drawable.cosmetic));
            MAIN_CATEGORY_LIST.add(new MainCategory(3, "electric_appliances", getString(R.string.electric_appliances), R.drawable.electric_appliances));
            MAIN_CATEGORY_LIST.add(new MainCategory(4, "women_fashion", getString(R.string.women_fashion), R.drawable.women_fasion));
            MAIN_CATEGORY_LIST.add(new MainCategory(5, "men_fashion", getString(R.string.men_fashion), R.drawable.men_fashion));
            MAIN_CATEGORY_LIST.add(new MainCategory(6, "jewelry", getString(R.string.jewelry), R.drawable.jewelry));
            MAIN_CATEGORY_LIST.add(new MainCategory(7, "laptop_pc", getString(R.string.laptop_pc), R.drawable.laptop_pc));
            MAIN_CATEGORY_LIST.add(new MainCategory(8, "car_moto", getString(R.string.car_moto), R.drawable.moto_car));

            return null;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            intent.putExtra("Json", mainAdsCategoryJSON);
            intent1.putExtra("Json", mainAdsCategoryJSON);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == Request_Permission_Code) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}