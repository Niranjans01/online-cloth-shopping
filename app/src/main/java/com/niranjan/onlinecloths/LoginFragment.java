package com.niranjan.onlinecloths;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment{

    private Activity context;
    Button btnLogin;
    EditText username,password;
    SharedPreferences shprf;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        btnLogin = view.findViewById(R.id.login);
        username = view.findViewById(R.id.usernamel);
        password = view.findViewById(R.id.passwordl);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("clicked frag","clicked me");
                shprf = context.getSharedPreferences("User", Context.MODE_PRIVATE);

                String user = shprf.getString("username",""); //username.getText().toString()
                String pass = shprf.getString("password",""); //password.getText().toString()

                if(user.equals(username.getText().toString()) || pass.equals(password.getText().toString())){
                    Toast.makeText(context, "Successful log in", Toast.LENGTH_SHORT).show();
                    Intent signin = new Intent(context, Dashboard.class);
                    startActivity(signin);
                }
                else {
                    Toast.makeText(context, "Incorrect usernme or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }


}
