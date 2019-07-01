package com.example.pmaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.pmaproject.database.ApplicationDatabase;
import com.example.pmaproject.database.entity.DBUser;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ApplicationDatabase ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

        List<DBUser> all = ad.dbUserDao().getAll();

        System.out.print(all);
        */

//       Intent intent = new Intent(getApplicationContext(), ListViewActivity.class);
//        startActivity(intent);

//        Intent intent = new Intent(getApplicationContext(), MapActivity.class);
//        startActivity(intent);

    }
}
