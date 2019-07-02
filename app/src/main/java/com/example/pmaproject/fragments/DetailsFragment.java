package com.example.pmaproject.fragments;


import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pmaproject.R;
import com.example.pmaproject.database.ApplicationDatabase;
import com.example.pmaproject.database.entity.DBStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment implements SensorEventListener{

    private ApplicationDatabase ad;
    private SensorManager mSensorManager;
    private List<DBStore> stores = new ArrayList<DBStore>();
    private DBStore storeDetails;

    public DetailsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ad = ApplicationDatabase.getInstance(getActivity());
        stores = ad.dbStoreDao().getAll();
        Bundle args = getArguments();
        int index = args.getInt("index", 0);
        for(DBStore s : stores){
            if(s.getId()==index){
                storeDetails = s;
            }

        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView address = view.findViewById(R.id.address);
        TextView contact = view.findViewById(R.id.lblContact);

        address.setText(storeDetails.getAddress());
        contact.setText(storeDetails.getContact());

        ImageButton callButton = view.findViewById(R.id.callImage);
        final TextView textView = view.findViewById(R.id.phone_number);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+ textView.getText().toString()));
                startActivity(intent);
            }
        });
    }

    private void registerSensorListener() {
        mSensorManager.registerListener(this,
                mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE),
                SensorManager.SENSOR_DELAY_FASTEST);
    }

    private void unregisterSensorListener() {
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mSensorManager = (SensorManager) this.getActivity().getSystemService(Activity.SENSOR_SERVICE);
    }

    @Override
    public void onResume() {
        super.onResume();
        // BIND sensor here with mActivity,
        // could also be done in other fragment lifecycle events,
        // depends on how you handle configChanges

    }

    @Override
    public void onPause() {
        super.onPause();
        // UNBIND sensor here from mActivity,
        // could also be done in other fragment lifecycle events,
        // depends on how you handle configChanges
    }

    @Override
    public void onStart() {
        super.onStart();
        this.registerSensorListener();
    }

    @Override
    public void onStop() {
        super.onStop();
        this.unregisterSensorListener();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.values[2] > 0.3f && event.values[1] > 0.4f && event.values[0] > 0.6f){
            Random random = new Random();
            int discount= this.getRandomDiscount(random, 5, 80, 5);
            Toast.makeText(getContext(),
                    "Your discount is " +
                            String.valueOf(discount) + "%!",
                    Toast.LENGTH_SHORT).show();
            this.onStop();
        }
        else if(event.values[2] < -0.7f && event.values[1] > -0.8f && event.values[0] > -0.6f) {
            Random random = new Random();
            int discount= this.getRandomDiscount(random, 5, 80, 5);
            Toast.makeText(getContext(),
                    "Your discount is " +
                            String.valueOf(discount) + "%!",
                    Toast.LENGTH_SHORT).show();
            this.onStop();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }

    public int getRandomDiscount(Random r, int start, int end, int step) {
        return r.nextInt((end - start) / step) * step + start;
    }
}