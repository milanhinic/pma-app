package com.example.pmaproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.ListView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.SimpleAdapter;


import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.example.pmaproject.database.ApplicationDatabase;
import com.example.pmaproject.database.entity.DBUser;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();




    private ApplicationDatabase ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ad = ApplicationDatabase.getInstance(this);

        /*
        DBUser user = new DBUser.Builder((long) 0)
                                        .setFirstName("Milan")
                                        .setLastName("Hinic")
                                        .setEmail("mm@gmail.com")
                                        .setPassword("goo")
                                        .setDefaultCity(1)
                                        .setPerimetar(30)
                                        .build();

        try {
            ad.dbUserDao().insertUser(user);
        } catch (Exception e) {

        }


    }






    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.list_nav) {
            startActivity(new Intent(getApplicationContext(), ListViewActivity.class));
        } else if (id == R.id.map_nav) {
            startActivity(new Intent(getApplicationContext(), MapActivity.class));
        } else if (id == R.id.settings_nav) {
            startActivity(new Intent(getApplicationContext(), SettingsActivity.class));

        } else if (id == R.id.account_nav) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
