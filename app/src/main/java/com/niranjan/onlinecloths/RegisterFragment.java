package com.niranjan.onlinecloths;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class RegisterFragment extends Fragment {

    Activity context;
Button btnReg;
EditText username,password;
SharedPreferences shprf;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register,container,false);
        context = getActivity();
        btnReg = view.findViewById(R.id.register);
        username = view.findViewById(R.id.usernamer);
        password = view.findViewById(R.id.passwordr);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shprf = context.getSharedPreferences("User", Context.MODE_PRIVATE);
                SharedPreferences.Editor shprfEditor= shprf.edit();

                shprfEditor.putString("username",username.getText().toString());
                shprfEditor.putString("password",password.getText().toString());
                shprfEditor.commit();
                Toast.makeText(context, "Successfully Registered", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, Dashboard.class);
                startActivity(intent);
            }
        });
        return view;
    }



}
