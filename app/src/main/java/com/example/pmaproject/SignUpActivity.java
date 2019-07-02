package com.example.pmaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.example.pmaproject.database.ApplicationDatabase;
import com.example.pmaproject.database.entity.DBUser;

import java.util.List;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void log_in(View view) {

        ApplicationDatabase ad;
        ad = ApplicationDatabase.getInstance(this);

        AutoCompleteTextView mFirstView;
        AutoCompleteTextView mLastView;
        AutoCompleteTextView mEmailView;
        EditText mPasswordView;

        mFirstView = (AutoCompleteTextView) findViewById(R.id.first_name);
        mLastView = (AutoCompleteTextView) findViewById(R.id.last_name);
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email_reg);
        mPasswordView = (EditText) findViewById(R.id.password_reg);


        DBUser user = new DBUser.Builder((long) 0)
                                        .setFirstName(mFirstView.getText().toString())
                                        .setLastName(mLastView.getText().toString())
                                        .setEmail(mEmailView.getText().toString())
                                        .setPassword(mPasswordView.getText().toString())
                                        .setDefaultCity(1)
                                        .setPerimetar(30)
                                        .build();

        try {
            ad.dbUserDao().insertUser(user);
        } catch (Exception e) {

        }

        List<DBUser> all = ad.dbUserDao().getAll();

        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }
}
