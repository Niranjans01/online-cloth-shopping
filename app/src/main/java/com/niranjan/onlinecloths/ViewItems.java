package com.niranjan.onlinecloths;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewItems extends AppCompatActivity {

    TextView itemName,itemPrice,itemDesc;
    ImageView itemImage;
    String intentExtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);

        itemName = findViewById(R.id.itemName);
        itemPrice = findViewById(R.id.itemPrice);
        itemDesc = findViewById(R.id.itemDesc);
        itemImage = findViewById(R.id.imageDisplay);


        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){
            Log.e("mero log", bundle.getString("itemName"));
            itemName.setText(bundle.getString("itemName"));
            itemPrice.setText(bundle.getString("itemPrice"));
            itemDesc.setText(bundle.getString("itemDesc"));
            itemImage.setImageResource(bundle.getInt("itemImage"));
        }


    }
}
