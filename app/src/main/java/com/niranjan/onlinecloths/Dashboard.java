package com.niranjan.onlinecloths;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dashboard extends AppCompatActivity {

    private Button btnAdditem;
    private RecyclerView recyclerAdapter;
    private String data = "";
    private List<ItemModel> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        setTitle("Dashboard");
        btnAdditem = findViewById(R.id.addItems);

        readItemsFile();
        recyclerAdapter = findViewById(R.id.itemsList);
        recyclerAdapter.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerAdapter.setAdapter(new ItemAdapter(itemList,getApplicationContext()));

        btnAdditem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent additemact = new Intent(Dashboard.this, ItemActivity.class);
                startActivity(additemact);
            }
        });
    }

    private void readItemsFile() {
        try {
            FileInputStream fis = openFileInput("items.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader brf = new BufferedReader(isr);
            while ((data = brf.readLine())!=null){
                String[] itoms = data.split("->");
                String imageName = itoms[2];
                int res = getResources().getIdentifier(imageName, "drawable", getPackageName());
                itemList.add(new ItemModel(itoms[0],res,itoms[3],itoms[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
