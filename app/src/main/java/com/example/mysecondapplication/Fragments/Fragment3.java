package com.example.mysecondapplication.Fragments;

import com.example.mysecondapplication.Activities.DataModel;
import com.example.mysecondapplication.Activities.CustomeAdapter;
import com.example.mysecondapplication.Activities.MainActivity;
import com.example.mysecondapplication.Activities.myData;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysecondapplication.R;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Fragment3 extends Fragment {

    private RecyclerView recyclerView;
    private CustomeAdapter adapter;
    private ArrayList<DataModel> dataSet;
    private EditText searchBox;
    private LinearLayoutManager layoutManager;
    private FirebaseAuth mAuth;
    private Button buttonGoToCart;

    public Fragment3() {}

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_3, container, false);

        mAuth = FirebaseAuth.getInstance();
        String userEmail = mAuth.getCurrentUser() != null ? mAuth.getCurrentUser().getEmail() : "No user logged in";

        TextView textViewLoggedAs = rootView.findViewById(R.id.textViewLoggedAs);
        textViewLoggedAs.setText("Logged as: " + userEmail);

        dataSet = new ArrayList<>();
        recyclerView = rootView.findViewById(R.id.resView);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i < myData.GetNameArray().length; i++) {
            dataSet.add(new DataModel(
                    myData.GetNameArray()[i],
                    myData.GetDescriptionArray()[i],
                    myData.GetDrawableArray()[i],
                    myData.GetId()[i],
                    0,
                    myData.GetPriceArray()[i]
            ));
        }

        adapter = new CustomeAdapter(dataSet, MainActivity.getPhoneNumberFromFirebase());
        recyclerView.setAdapter(adapter);

        searchBox = rootView.findViewById(R.id.searchBox);
        if (searchBox != null) {
            searchBox.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    adapter.filter(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {
                    adapter.filter(s.toString());
                }
            });
        }
        buttonGoToCart = rootView.findViewById(R.id.buttonGoToCart);
        buttonGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_fragment3_to_fragment4);
            }
        });

        return rootView;
    }
}
