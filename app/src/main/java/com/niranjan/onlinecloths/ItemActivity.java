package com.niranjan.onlinecloths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class ItemActivity extends AppCompatActivity {

    EditText itemname,itemprice,itemimagename,itemdescription;
    Button btnadditem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        setTitle("Add Item");

        itemname = findViewById(R.id.itemname);
        itemprice = findViewById(R.id.itemprice);
        itemimagename = findViewById(R.id.itemimagename);
        itemdescription = findViewById(R.id.itemdesc);

        btnadditem = findViewById(R.id.btn_additem);
        btnadditem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    PrintStream printStream = new PrintStream(openFileOutput("items.txt", MODE_PRIVATE|MODE_APPEND));
                    printStream.println(itemname.getText().toString()+ "->"+itemprice.getText().toString()+ "->"+itemimagename.getText().toString() + "->"+itemdescription.getText().toString());
                    Toast.makeText(ItemActivity.this, "Items added to : "+getFilesDir(), Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(ItemActivity.this,Dashboard.class);
                    startActivity(intent1);
                    finish();
                }
                catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        });
    }
}
