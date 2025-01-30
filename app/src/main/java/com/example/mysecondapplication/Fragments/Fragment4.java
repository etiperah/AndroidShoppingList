package com.example.mysecondapplication.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysecondapplication.Activities.CustomeAdapter;
import com.example.mysecondapplication.Activities.DataModel;
import com.example.mysecondapplication.Activities.MainActivity;
import com.example.mysecondapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Fragment4 extends Fragment {

    private RecyclerView recyclerView;
    private CustomeAdapter adapter;
    private ArrayList<DataModel> cartData;
    private FirebaseAuth mAuth;

    public Fragment4() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_4, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.resView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        ArrayList<DataModel> dataSet = new ArrayList<>();

        dataSet.add(new DataModel("Item", "Description", R.drawable.ic_launcher_background, 1, 1, 100));

        CustomeAdapter adapter = new CustomeAdapter(dataSet, MainActivity.getPhoneNumberFromFirebase());
        recyclerView.setAdapter(adapter);

        return rootView;
    }


    private void loadCartData(String phone) {
        DatabaseReference cartRef = FirebaseDatabase.getInstance()
                .getReference("users").child(MainActivity.getPhoneNumberFromFirebase()).child("cart");

        cartRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<DataModel> dataSet = new ArrayList<>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    DataModel item = snapshot.getValue(DataModel.class);
                    if (item != null) {
                        dataSet.add(item);
                    }
                }

                Log.d("Firebase", "Loaded " + dataSet.size() + " items.");

                if (adapter == null) {
                    adapter = new CustomeAdapter(dataSet, MainActivity.getPhoneNumberFromFirebase());
                    recyclerView.setAdapter(adapter);
                } else {
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Firebase", "Failed to read cart data: " + databaseError.getMessage());
            }
        });
    }
}
