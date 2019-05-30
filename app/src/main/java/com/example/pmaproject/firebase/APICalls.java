package com.example.pmaproject.firebase;

import android.util.Log;

import com.example.pmaproject.models.Store;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;

public class APICalls {

    private static APICalls instance;
    private DatabaseReference mDatabase;
    private DatabaseReference storesReference;


    private APICalls()
    {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        storesReference = mDatabase.child(DatabaseEntities.STORES);

    }

    public static APICalls getInstance() {
        if (instance == null) {
            instance = new APICalls();
        }
        return instance;
    }

    public void addStore(Store store) {
        String key = mDatabase.child(DatabaseEntities.STORES).push().getKey();
        store.setId(key);
        mDatabase.child("stores").child(key).setValue(store);
    }

    public List<Store> getStores()  {

        final List<Store> retValues = new ArrayList<>();

        storesReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                        retValues.add(postSnapshot.getValue(Store.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("Firebase read error " ,databaseError.getMessage());
            }
        });

        return retValues;

    }



}
