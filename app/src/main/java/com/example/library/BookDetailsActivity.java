package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BookDetailsActivity extends AppCompatActivity {

    TextView etTitle, etDescription, etPrice;
    Button back,addToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        Intent it=getIntent();
        String intTitle=it.getStringExtra("text1");
        String intDescription=it.getStringExtra("text2");
        String intPrice=it.getStringExtra("text3");

        etTitle=findViewById(R.id.title);
        etDescription=findViewById(R.id.description);
        etPrice=findViewById(R.id.price);

        etTitle.setText(intTitle);
        etPrice.setText(intPrice);
        etDescription.setText(intDescription);


        String title = etTitle.getText().toString();
        String description = etDescription.getText().toString();
        String price = etPrice.getText().toString();


        back= findViewById(R.id.back);
        addToCart=findViewById(R.id.addToCart);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookDetailsActivity.this,CatagoryDetails.class));
            }
        });

        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username","");

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username=sharedPreferences.getString("username","");
                Database db=new Database(getApplicationContext(),"library",null,1);
                int check=db.checkCart(username, title);

                if(check==1){
                    String message = "You already have this book in your cart";
                    Toast.makeText(BookDetailsActivity.this, message, Toast.LENGTH_SHORT).show();
                }else{
                    db.addToCart(username,intTitle,intPrice);
                    Toast.makeText(BookDetailsActivity.this, "Book added to your cart successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}