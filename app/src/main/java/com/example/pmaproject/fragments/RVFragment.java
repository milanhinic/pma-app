package com.example.pmaproject.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pmaproject.MainActivity;
import com.example.pmaproject.R;
import com.example.pmaproject.RecyclerViewAdapter;
import com.example.pmaproject.database.ApplicationDatabase;
import com.example.pmaproject.database.entity.DBUser;

import java.util.ArrayList;
import java.util.List;


public class RVFragment extends Fragment {

    private ApplicationDatabase ad;
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ad = ApplicationDatabase.getInstance(getActivity());
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initImageBitmaps();
        initRecyclerView(view);
    }

    private void initImageBitmaps(){

        DBUser user = ad.dbUserDao().getLoggedInUser(true);

        List<String> allNames =  ad.dbStoreDao().getAllStoreNames(user.getDefaultCity());

        mNames.addAll(allNames);
        /*
        mNames.add("Havasu Falls");
        mNames.add("Trondheim");
        mNames.add("Portugal");
        mNames.add("Rocky Mountain National Park");
        mNames.add("Mahahual");
        mNames.add("Frozen Lake");
        mNames.add("White Sands Desert");
        mNames.add("Austrailia");
        mNames.add("Washington");
        */

    }

    private void initRecyclerView(View v){
        RecyclerView recyclerView = v.findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(), mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
