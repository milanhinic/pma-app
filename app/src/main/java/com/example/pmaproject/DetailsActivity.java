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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pmaproject.database.ApplicationDatabase;
import com.example.pmaproject.database.entity.DBStore;
import com.example.pmaproject.database.entity.DBUser;

import java.util.List;
import java.util.Random;

public class DetailsActivity extends AppCompatActivity {

    /*private SensorManager mSensorManager;
    private Sensor gyroscopeSensor;
    private SensorEventListener sensorEventListener;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_details);

       /* mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
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
        };*/
    }

    @Override
    protected void onResume(){
        super.onResume();
       // mSensorManager.registerListener(sensorEventListener, gyroscopeSensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected  void onPause(){
        super.onPause();
        //mSensorManager.unregisterListener(sensorEventListener);
    }

   /* public void call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        TextView textView = findViewById(R.id.phone_number);
        intent.setData(Uri.parse("tel:"+ textView.getText().toString()));
        startActivity(intent);
    }*/

    public void like(View view) {
        ApplicationDatabase ad;
        ad = ApplicationDatabase.getInstance(this);
        List<DBUser> users = ad.dbUserDao().getAll();
        TextView name = findViewById(R.id.name);
        String n = (String)name.getText();
        for(DBUser u: users){
            if(u.getLoggedIn()==true){
                u.setFavorites(n);
            }

        }
      //  ImageButton image = findViewById(R.id.like);
      //  image.setImageResource(R.drawable.heart);



    }
}
