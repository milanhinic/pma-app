package com.example.pmaproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.pmaproject.database.ApplicationDatabase;
import com.example.pmaproject.database.entity.DBCity;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    private static final String TAG = "ListViewActivity";
    private ApplicationDatabase ad;

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ad = ApplicationDatabase.getInstance(this);

        Log.d(TAG, "onCreate: started.");
        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");


        mNames.add("Havasu Falls");
        mNames.add("Havasu Falls");
        mNames.add("Havasu Falls");
        mNames.add("Havasu Falls");
        mNames.add("Havasu Falls");


        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private void initData() {

        DBCity city1 = new DBCity.Builder((long) 0 )
                .setName("Beograd")
                .setLongitude(20.457037)
                .setLatitude(44.817690)
                .build();

        DBCity city2 = new DBCity.Builder((long) 0 )
                .setName("Novi Sad")
                .setLongitude(19.845092)
                .setLatitude(45.255155)
                .build();

        DBCity city3 = new DBCity.Builder((long) 0 )
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

    }
}
