package com.example.pmaproject;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.pmaproject.database.ApplicationDatabase;
import com.example.pmaproject.database.dao.DBItemDao;
import com.example.pmaproject.database.entity.DBCity;
import com.example.pmaproject.database.entity.DBItem;
import com.example.pmaproject.database.entity.DBStore;
import com.example.pmaproject.fragments.MapFragment;
import com.example.pmaproject.fragments.RVFragment;
import com.example.pmaproject.fragments.SettingsFragment;
import com.example.pmaproject.services.NotificationAlarmReceiver;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.ListView;

import android.os.SystemClock;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;
import android.view.Menu;
import android.widget.SimpleAdapter;


import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.example.pmaproject.database.ApplicationDatabase;
import com.example.pmaproject.database.entity.DBUser;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private ApplicationDatabase ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        ad = ApplicationDatabase.getInstance(this);
        initData();
        sendRepeatingNotification();

        Fragment f = new RVFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, f);
        ft.commit();

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

        List<DBUser> users = ad.dbUserDao().getAll();

        */
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_help) {

            startActivity(new Intent(getApplicationContext(), HelpActivity.class));
        }
        else if (id == R.id.action_favorite){
            List<DBUser> users = ad.dbUserDao().getAll();

            for(DBUser u: users){
                if(u.getLoggedIn()==true){
                    String fav = u.getFavorites();
                    startActivity(new Intent(getApplicationContext(), FavouritesActivity.class));

                }

            }
        }
        else if (id == R.id.action_sign_out){
            DBUser user = ad.dbUserDao().getLoggedInUser(true);
            user.setLoggedIn(false);
            ad.dbUserDao().updateUser(user);
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment f;
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        if (id == R.id.list_nav) {
            f = new RVFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.addToBackStack(null);
            ft.replace(R.id.container, f);
            ft.commit();
        } else if (id == R.id.map_nav) {
            f = new MapFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.addToBackStack(null);

            ft.replace(R.id.container, f);
            ft.commit();
        } else if (id == R.id.settings_nav) {
            f = new SettingsFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.addToBackStack(null);

            ft.replace(R.id.container, f);
            ft.commit();
        } else if (id == R.id.log_out) {
            // deactivate user
//            DBUser user = ad.dbUserDao().getLoggedInUser(true);
//            user.setLoggedIn(false);
//            ad.dbUserDao().updateUser(user);
//            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void sendRepeatingNotification() {
        Intent intentAlarm = new Intent(this, NotificationAlarmReceiver.class);
        System.out.println("calling Alarm receiver ");
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        //set the notification to repeat every fifteen minutes
        long startTime = 1*60*1000; // 2 min
        // set unique id to the pending item, so we can call it when needed
        PendingIntent pi = PendingIntent.getBroadcast(this, 001, intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.setRepeating(AlarmManager.RTC, SystemClock.elapsedRealtime() +
                startTime, 20*1000, pi);

    }

    private void initData() {

        if(ad.dbCityDao().getAll().size() == 0 && ad.dbStoreDao().getAll().size() == 0 && ad.dbItemDao().getAll().size() == 0) {

            DBCity city1 = new DBCity.Builder((long) 0)
                    .setName("Beograd")
                    .setLongitude(20.457037)
                    .setLatitude(44.817690)
                    .build();

            DBCity city2 = new DBCity.Builder((long) 0)
                    .setName("Novi Sad")
                    .setLongitude(19.845092)
                    .setLatitude(45.255155)
                    .build();

            DBCity city3 = new DBCity.Builder((long) 0)
                    .setName("Nis")
                    .setLongitude(21.896903)
                    .setLatitude(43.317894)
                    .build();


            try {
                ad.dbCityDao().insertCity(city1);
                ad.dbCityDao().insertCity(city2);
                ad.dbCityDao().insertCity(city3);
            } catch (Exception e) {

            }


            DBStore storeb1 = new DBStore.Builder((long) 0)
                    .setName("Zara")
                    .setAddress("Kneza Mihaila 15")
                    .setLatitude(44.816080)
                    .setLongitude(20.458617)
                    .setDesription("Bringing attractive and responsible fashion, and improve the quality of customer service, are Zara priorities")
                    .setContact("0112627722")
                    .setCityId(1)
                    .build();

            DBStore storeb2 = new DBStore.Builder((long) 0)
                    .setName("New Yorker")
                    .setAddress("Bulevar Mihajla Pupina 6")
                    .setLatitude(44.815236)
                    .setLongitude(20.436696)
                    .setDesription("Dress for the moment. - Every moment is unique.")
                    .setContact("01112601423")
                    .setCityId(1)
                    .build();

            DBStore storeb3 = new DBStore.Builder((long) 0)
                    .setName("Planeta sport")
                    .setAddress("Kneza Mihaila 21")
                    .setLatitude(44.816574)
                    .setLongitude(20.458227)
                    .setDesription("Sportska radnja za sve")
                    .setContact("0698788387")
                    .setCityId(1)
                    .build();


            DBStore storens1 = new DBStore.Builder((long) 0)
                    .setName("Zara")
                    .setAddress("Bulevar Mihajla Pupina 1")
                    .setLatitude(45.253708)
                    .setLongitude(19.844015)
                    .setDesription("Bringing attractive and responsible fashion, and improve the quality of customer service, are Zara priorities")
                    .setContact("0216614575")
                    .setCityId(2)
                    .build();

            DBStore storens2 = new DBStore.Builder((long) 0)
                    .setName("New Yorker")
                    .setAddress("Sentandrejski put 11")
                    .setLatitude(45.274725)
                    .setLongitude(19.827521)
                    .setDesription("Dress for the moment. - Every moment is unique.")
                    .setContact("021445816")
                    .setCityId(2)
                    .build();

            DBStore storens3 = new DBStore.Builder((long) 0)
                    .setName("Planeta sport")
                    .setAddress("Zmaj Jovina 22")
                    .setLatitude(45.256359)
                    .setLongitude(19.847589)
                    .setDesription("Sportska radnja za sve")
                    .setContact("0698788337")
                    .setCityId(2)
                    .build();


            DBStore storenis1 = new DBStore.Builder((long) 0)
                    .setName("Planeta sport")
                    .setAddress("Obrenoviceva 17")
                    .setLatitude(43.319275)
                    .setLongitude(21.895071)
                    .setDesription("Sportska radnja za sve")
                    .setContact("0698788368")
                    .setCityId(3)
                    .build();

            try {
                ad.dbStoreDao().insertStore(storeb1);
                ad.dbStoreDao().insertStore(storeb2);
                ad.dbStoreDao().insertStore(storeb3);
                ad.dbStoreDao().insertStore(storens1);
                ad.dbStoreDao().insertStore(storens2);
                ad.dbStoreDao().insertStore(storens3);
                ad.dbStoreDao().insertStore(storenis1);


            } catch (Exception e) {

            }


            DBItem item1 = new DBItem.Builder((long) 0)
                    .setName("Jeans")
                    .setDiscount(20)
                    .setPrice(1999.99)
                    .setFromDate("2019-06-01")
                    .setToDate("2019-06-10")
                    .setStoreId(1)
                    .build();

            DBItem item2 = new DBItem.Builder((long) 0)
                    .setName("Maica")
                    .setDiscount(10)
                    .setPrice(2999.99)
                    .setFromDate("2019-06-13")
                    .setToDate("2019-06-19")
                    .setStoreId(1)
                    .build();

            DBItem item3 = new DBItem.Builder((long) 0)
                    .setName("Maica")
                    .setDiscount(10)
                    .setPrice(3589.99)
                    .setFromDate("2019-06-13")
                    .setToDate("2019-06-19")
                    .setStoreId(2)
                    .build();

            DBItem item4 = new DBItem.Builder((long) 0)
                    .setName("Bokserice")
                    .setDiscount(5)
                    .setPrice(1000.00)
                    .setFromDate("2019-05-13")
                    .setToDate("2019-06-1")
                    .setStoreId(2)
                    .build();

            DBItem item5 = new DBItem.Builder((long) 0)
                    .setName("Maica")
                    .setDiscount(10)
                    .setPrice(3589.99)
                    .setFromDate("2019-06-13")
                    .setToDate("2019-06-19")
                    .setStoreId(3)
                    .build();

            DBItem item6 = new DBItem.Builder((long) 0)
                    .setName("Bokserice")
                    .setDiscount(5)
                    .setPrice(1000.00)
                    .setFromDate("2019-05-13")
                    .setToDate("2019-06-1")
                    .setStoreId(3)
                    .build();

            DBItem item7 = new DBItem.Builder((long) 0)
                    .setName("Jeans")
                    .setDiscount(20)
                    .setPrice(1999.99)
                    .setFromDate("2019-06-01")
                    .setToDate("2019-06-10")
                    .setStoreId(4)
                    .build();

            DBItem item8 = new DBItem.Builder((long) 0)
                    .setName("Maica")
                    .setDiscount(10)
                    .setPrice(2999.99)
                    .setFromDate("2019-06-13")
                    .setToDate("2019-06-19")
                    .setStoreId(4)
                    .build();

            DBItem item9 = new DBItem.Builder((long) 0)
                    .setName("Maica")
                    .setDiscount(10)
                    .setPrice(3589.99)
                    .setFromDate("2019-06-13")
                    .setToDate("2019-06-19")
                    .setStoreId(5)
                    .build();

            DBItem item10 = new DBItem.Builder((long) 0)
                    .setName("Bokserice")
                    .setDiscount(5)
                    .setPrice(1000.00)
                    .setFromDate("2019-05-13")
                    .setToDate("2019-06-1")
                    .setStoreId(5)
                    .build();

            DBItem item11 = new DBItem.Builder((long) 0)
                    .setName("Bokserice")
                    .setDiscount(5)
                    .setPrice(1000.00)
                    .setFromDate("2019-05-13")
                    .setToDate("2019-06-1")
                    .setStoreId(6)
                    .build();

            DBItem item12 = new DBItem.Builder((long) 0)
                    .setName("Jeans")
                    .setDiscount(20)
                    .setPrice(1999.99)
                    .setFromDate("2019-06-01")
                    .setToDate("2019-06-10")
                    .setStoreId(6)
                    .build();

            DBItem item13 = new DBItem.Builder((long) 0)
                    .setName("Bokserice")
                    .setDiscount(5)
                    .setPrice(1300.00)
                    .setFromDate("2019-05-13")
                    .setToDate("2019-06-1")
                    .setStoreId(7)
                    .build();

            DBItem item14 = new DBItem.Builder((long) 0)
                    .setName("Bokserice")
                    .setDiscount(5)
                    .setPrice(1500.00)
                    .setFromDate("2019-05-13")
                    .setToDate("2019-06-1")
                    .setStoreId(7)
                    .build();

            try {
                ad.dbItemDao().insertItem(item1);
                ad.dbItemDao().insertItem(item2);
                ad.dbItemDao().insertItem(item3);
                ad.dbItemDao().insertItem(item4);
                ad.dbItemDao().insertItem(item5);
                ad.dbItemDao().insertItem(item6);
                ad.dbItemDao().insertItem(item7);
                ad.dbItemDao().insertItem(item8);
                ad.dbItemDao().insertItem(item9);
                ad.dbItemDao().insertItem(item10);
                ad.dbItemDao().insertItem(item11);
                ad.dbItemDao().insertItem(item12);
                ad.dbItemDao().insertItem(item13);
                ad.dbItemDao().insertItem(item14);

            } catch (Exception e) {

            }


        }
    }

}
