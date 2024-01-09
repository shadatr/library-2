package com.example.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class findBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_book);

        ImageView home=findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(findBook.this,HomeActivity.class));
            }
        });

        CardView romance=findViewById(R.id.cardRomance);
        romance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(findBook.this,CatagoryDetails.class);
                it.putExtra("title", "Romance");
                startActivity(it);
            }
        });

        CardView fantacy=findViewById(R.id.cardFantasy);
        fantacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(findBook.this,CatagoryDetails.class);
                it.putExtra("title", "Fantacy");
                startActivity(it);
            }
        });

        CardView Biography=findViewById(R.id.cardBiography);
        Biography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(findBook.this,CatagoryDetails.class);
                it.putExtra("title", "Biography/Memoir");
                startActivity(it);
            }
        });

        CardView fiction=findViewById(R.id.cardFiction);
        fiction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(findBook.this,CatagoryDetails.class);
                it.putExtra("title", "Fiction");
                startActivity(it);
            }
        });

        CardView history=findViewById(R.id.cardHistory);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(findBook.this,CatagoryDetails.class);
                it.putExtra("title", "History");
                startActivity(it);
            }
        });
        CardView scienceFiction=findViewById(R.id.cardScienceFiction);
        scienceFiction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(findBook.this,CatagoryDetails.class);
                it.putExtra("title", "Science Fiction");
                startActivity(it);
            }
        });
    }
}