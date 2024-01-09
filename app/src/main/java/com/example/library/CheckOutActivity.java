package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckOutActivity extends AppCompatActivity {

    ImageView back;
    Button order;
    HashMap<String,String> item;
    TextView total;
    private String[][] packages={};

    EditText name,email,phone,address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        name= findViewById(R.id.name);
        address= findViewById(R.id.address);
        email= findViewById(R.id.email);
        phone= findViewById(R.id.phone);
        total= findViewById(R.id.total);
        back= findViewById(R.id.back);
        order= findViewById(R.id.order);

        Intent it=getIntent();
        String username=it.getStringExtra("username");
        String product_number=it.getStringExtra("product_number");
        String price=it.getStringExtra("price");
        total.setText("The total is "+price+"$");

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.length()==0||address.length()==0||email.length()==0||email.length()==0||phone.length()==0){
                    Toast.makeText(CheckOutActivity.this, "Please fill all details", Toast.LENGTH_SHORT).show();
                }else{
                    Database db=new Database(getApplicationContext(),"library",null,1);

                    db.addToOrder(username, product_number, price, name.getText().toString(), address.getText().toString(), phone.getText().toString(), email.getText().toString());
                    db.removeCart(username);
                    Toast.makeText(CheckOutActivity.this, "the order placed successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(CheckOutActivity.this,CartActivity.class));

                }

            }});

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckOutActivity.this,CartActivity.class));
            }
        });
    }
}