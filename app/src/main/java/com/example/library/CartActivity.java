package com.example.library;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class CartActivity extends AppCompatActivity {

    TextView etTotal;
    ImageView back;
    float total;
    ArrayList List;
    HashMap<String,String> item;
    SimpleAdapter sa;
    Button checkout;
    private String[][] packages={};
    TextView noItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username","");

        Database db=new Database(getApplicationContext(),"library",null,1);
        ArrayList arr=db.getCartData(username);

        noItems=findViewById(R.id.noItems);

        if(arr.size()==0){
            noItems.setText("You don't have any items in your cart!");
        }

        packages= new String[arr.size()][];
        for(int i=0;i<packages.length;i++){
            packages[i]=new String[3];
        }

        for (int i = 0; i < arr.size(); i++) {
            String arrData = arr.get(i).toString();
            String[] strData = arrData.split(java.util.regex.Pattern.quote(" "));

            packages[i][0] = strData[0] + strData[1];

            StringBuilder productName = new StringBuilder();
            for (int j = 2; j < strData.length; j++) {
                productName.append(strData[j]).append(" ");
            }
            // Remove trailing space
            productName.deleteCharAt(productName.length() - 1);
            packages[i][1] = productName.toString();

            String priceString = strData[1].replaceAll("[^\\d.]", "");

            total += Float.parseFloat(priceString);
        }

        etTotal=findViewById(R.id.total);
        etTotal.setText("total is: "+total+"$");

        List = new ArrayList();
        for (int i=0;i<packages.length;i++){
            item= new HashMap<String,String>();
            item.put("line1",packages[i][1]);
            item.put("line2",packages[i][0]);
            List.add(item);
        }
        sa=new SimpleAdapter(this,List,R.layout.cart_product_activity, new String[]{"line1","line2"}, new int[]{R.id.line1,R.id.line2});
        ListView lst= findViewById(R.id.lst);
        lst.setAdapter(sa);

        back= findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this,HomeActivity.class));
            }
        });

        checkout= findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent(CartActivity.this,CheckOutActivity.class);
                it.putExtra("username",username);
                it.putExtra("price", String.valueOf(total));
                it.putExtra("product_number",String.valueOf(packages.length));
                startActivity(it);
            }
        });

    }
}