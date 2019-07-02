package com.example.pmaproject.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pmaproject.MainActivity;
import com.example.pmaproject.R;
import com.example.pmaproject.database.ApplicationDatabase;
import com.example.pmaproject.database.entity.DBCity;
import com.example.pmaproject.database.entity.DBUser;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private ApplicationDatabase ad;
    private TextView cityView;
    private TextView perimeterView;
    private String city;
    private String perimetar;
    private Button submitButton;

    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ad = ApplicationDatabase.getInstance(getActivity());
        return inflater.inflate(R.layout.fragment_settings, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> cityName = ad.dbCityDao().getAllCitiesNames();
        Spinner spinner1 = view.findViewById(R.id.spinner1);
        //  ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cities, android.R.layout.simple_spinner_item );
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, cityName);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);

        Spinner spinner2 = view.findViewById(R.id.spinner2);
        //  ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cities, android.R.layout.simple_spinner_item );
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.perimeter));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        Spinner spinner3 = view.findViewById(R.id.spinner3);
        //  ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cities, android.R.layout.simple_spinner_item );
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.theme));
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);

        submitButton = (Button) view.findViewById(R.id.f_submit_button);
        cityView = (TextView) view.findViewById(R.id.f_city);
        perimeterView = (TextView) view.findViewById(R.id.f_perimeter);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(perimetar != null && city != null) {

                    DBUser dbUser =  ad.dbUserDao().getLoggedInUser(true);
                    if(!perimetar.equals("")) {
                        Integer perimeterInt = Integer.parseInt(perimetar);
                        dbUser.setPerimetar(perimeterInt);
                    }

                    if(!city.equals("")) {
                        DBCity dbCity =  ad.dbCityDao().getByName(city);
                        Integer dbCityId = Integer.getInteger(String.valueOf(dbCity.getId()));
                        dbUser.setDefaultCity(dbCityId);
                    }

                    ad.dbUserDao().updateUser(dbUser);
                    Toast.makeText(getContext(), "Changed settings", Toast.LENGTH_SHORT).show();

                }


                /*
                if(perimetar.equals("") || perimetar.equals("Choose the perimeter")) {
                    perimeterView.setError("Choose the perimeter");
                    return;
                }
                if(city.equals("")) {
                    cityView.setError("Chose the city");
                    return;
                }

                Integer perimeterInt = Integer.getInteger(perimetar);

                DBCity dbCity =  ad.dbCityDao().getByName(city);
                Integer dbCityId = Integer.getInteger(String.valueOf(dbCity.getId()));
                DBUser dbUser =  ad.dbUserDao().getLoggedInUser(true);
                dbUser.setPerimetar(perimeterInt);
                dbUser.setDefaultCity(dbCityId);
                ad.dbUserDao().updateUser(dbUser);
                */
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();

        if(text.length() > 0) {
            DBCity dbCity = ad.dbCityDao().getByName(text);
            if(dbCity != null) {
                city = text;
            } else {
                if(text.contains("0") || text.contains("1") || text.contains("5")) {
                    perimetar = text;
                }
            }
        }

        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
