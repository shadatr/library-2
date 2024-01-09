package com.example.library;

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
// ... (other imports)

public class OrderDetailsActivity extends AppCompatActivity {
    ImageView back;
    Button order;
    ArrayList List;
    HashMap<String,String> item;
    SimpleAdapter sa;
    Button checkout;
    private String[][] packages={};
    TextView noItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username","");

        Database db=new Database(getApplicationContext(),"library",null,1);
        ArrayList arr=db.getOrders(username);

        noItems=findViewById(R.id.noItems);

        if(arr.size()==0){
            noItems.setText("You don't have any order yet!");
        }

        packages= new String[arr.size()][];
        for(int i=0;i<packages.length;i++){
            packages[i]=new String[7];
        }

        for (int i = 0; i < arr.size(); i++) {
            String arrData = arr.get(i).toString();
            String[] strData = arrData.split(java.util.regex.Pattern.quote(" "));

            for (int j = 0; j < Math.min(strData.length, 7); j++) {
                packages[i][j] = strData[j];
            }


            StringBuilder productName = new StringBuilder();
            for (int j = 2; j < strData.length; j++) {
                productName.append(strData[j]).append(" ");
            }
            // Remove trailing space
            productName.deleteCharAt(productName.length() - 1);
            packages[i][1] = productName.toString();

            String priceString = strData[1].replaceAll("[^\\d.]", "");
        }

        List = new ArrayList();
        for (int i=0;i<packages.length;i++){
            item= new HashMap<String,String>();
            item.put("line1",packages[i][2]);
            item.put("line2",packages[i][4]);
            item.put("line3",packages[i][5]);
            item.put("line4",packages[i][3]);
            item.put("line6","total:"+ packages[i][0]+"$");

            List.add(item);
        }
        sa=new SimpleAdapter(this,List,R.layout.multi_lines_order, new String[]{"line1","line2","line3","line4","line6"}, new int[]{R.id.line1,R.id.line2,R.id.line3,R.id.line4,R.id.line6});
        ListView lst= findViewById(R.id.list);
        lst.setAdapter(sa);

        back= findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderDetailsActivity.this,HomeActivity.class));
            }
        });
    }
}
