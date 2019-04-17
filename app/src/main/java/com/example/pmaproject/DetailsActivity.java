package com.example.pmaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
    }

    public void call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        TextView textView = findViewById(R.id.phone_number);
        intent.setData(Uri.parse("tel:"+ textView.getText().toString()));
        startActivity(intent);
    }
}
