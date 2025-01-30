package com.example.mysecondapplication.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.mysecondapplication.Activities.MainActivity;
import com.example.mysecondapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment2() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        EditText emailEditText = view.findViewById(R.id.editTextEmailReg);
        Button buttonRegister = view.findViewById(R.id.buttonRegister);
        EditText passwordEditText = view.findViewById((R.id.editTextPasswordReg));
        EditText passwordconfirmEditText = view.findViewById((R.id.editTextPasswordConfirmReg));
        EditText phoneEditText = view.findViewById((R.id.editTextPhone));

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.reg();
                mainActivity.addData();
                Navigation.findNavController(view).navigate(R.id.action_fragment2_to_fragment1);

                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String passwordconfirm = passwordconfirmEditText.getText().toString().trim();
                String phone = phoneEditText.getText().toString().trim();

                buttonRegister.setClickable(false);

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (!(passwordconfirm.equals(password))) {
                    passwordEditText.setError("The passwords are not match");
                }
                if (!email.isEmpty() && !password.isEmpty() && !passwordconfirm.isEmpty() && !phone.isEmpty()) {
                    buttonRegister.setClickable(true);
                    Navigation.findNavController(view).navigate(R.id.action_fragment1_to_fragment3);
                } else {
                    emailEditText.setError("Please fill all the fields");
                }
            }
        });
        return view;
    }
}