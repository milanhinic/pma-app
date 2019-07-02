package com.example.pmaproject.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pmaproject.R;
import com.example.pmaproject.database.ApplicationDatabase;
import com.example.pmaproject.database.entity.DBCity;
import com.example.pmaproject.database.entity.DBStore;
import com.example.pmaproject.database.entity.DBUser;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;


public class MapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ApplicationDatabase ad;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ad = ApplicationDatabase.getInstance(getActivity());
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        DBUser user = ad.dbUserDao().getLoggedInUser(true);

        // get default city from user
        DBCity defaultCity= ad.dbCityDao().getById(user.getDefaultCity());
        List<DBStore> stores = ad.dbStoreDao().getAllStores(user.getDefaultCity());

        LatLng cityMarker = new LatLng(defaultCity.getLatitude(), defaultCity.getLongitude());

        for (DBStore store: stores) {
            LatLng storeMarker = new LatLng(store.getLatitude(), store.getLongitude());
            mMap.addMarker(new MarkerOptions().position(storeMarker).title(store.getName()));
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(cityMarker));
//        // Add a marker in Sydney and move the camera
//        LatLng noviSad = new LatLng(45.255180, 19.845122);
//        mMap.addMarker(new MarkerOptions().position(noviSad).title("Marker in Novi Sad"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(noviSad));
    }


}
