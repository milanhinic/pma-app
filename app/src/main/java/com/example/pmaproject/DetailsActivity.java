package com.example.pmaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class DetailsActivity extends AppCompatActivity {

    private SensorManager mSensorManager;
    private Sensor gyroscopeSensor;
    private SensorEventListener sensorEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        gyroscopeSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        if (gyroscopeSensor == null) {
            Toast.makeText(this, "Device has no gyroscope", Toast.LENGTH_SHORT).show();
        }

        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if(event.values[2] > 0.3f){
                    int random = new Random().nextInt(40) + 5;
                    Toast.makeText(getApplicationContext(),
                                "Your discount is " +
                                     String.valueOf(random) + "%!",
                                     Toast.LENGTH_SHORT).show();
                    onPause();
                }
                else if(event.values[2] < -0.7f) {
                    int random = new Random().nextInt(61) + 20;
                    Toast.makeText(getApplicationContext(),
                                    "Your discount is " +
                                        String.valueOf(random) + "%!",
                                        Toast.LENGTH_SHORT).show();
                    onPause();
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }

    @Override
    protected void onResume(){
        super.onResume();
        mSensorManager.registerListener(sensorEventListener, gyroscopeSensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected  void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(sensorEventListener);
    }

    public void call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        TextView textView = findViewById(R.id.phone_number);
        intent.setData(Uri.parse("tel:"+ textView.getText().toString()));
        startActivity(intent);
    }
}
