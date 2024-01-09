package com.example.library;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry1= "Create table users(username text, email text,password text)";
        db.execSQL(qry1);

        String qry2= "Create table cart(username text, price text,product text)";
        db.execSQL(qry2);

        String qry3= "Create table orders(username text, price text,product text,name text, email text, address text, phone text)";
        db.execSQL(qry3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void register(String username, String password, String email){
        ContentValues cv= new ContentValues();
        cv.put("username", username);
        cv.put("password", password);
        cv.put("email", email);
        SQLiteDatabase db=getWritableDatabase();
        db.insert("users",null,cv);
        db.close();
    }

    public int login(String username, String password){
        int result =0;
        String str[]=new String[2];
        str[0]=username;
        str[1]=password;
        SQLiteDatabase db= getReadableDatabase();
        Cursor c=db.rawQuery("select * from users where username=? and password=?",str);
        if(c.moveToFirst()){
            result=1;
        }
        return result;
    }

    public void addToCart(String username, String product, String price) {
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("product", product);
        cv.put("price", price);

        try {
            SQLiteDatabase db = getWritableDatabase();
            db.insert("cart", null, cv);
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int checkCart(String username, String product){
        int result =0;
        String str[]=new String[2];
        str[0]=username;
        str[1]=product;
        try {
            SQLiteDatabase db = getWritableDatabase();
            Cursor c=db.rawQuery("select * from cart where username=? and product=?",str);
            if(c.moveToFirst()){
                result=1;
            }
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public void removeCart(String username){
        int result =0;
        String str[]=new String[1];
        str[0]=username;
        SQLiteDatabase db=getWritableDatabase();
        db.delete("cart","username=?",str);
        db.close();
    }

    public ArrayList<String> getCartData(String username) {
        ArrayList<String> arr = new ArrayList<>();
        String str[] = new String[1];
        str[0] = username;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from cart where username=?", str);
        if (c.moveToFirst()) {
            do {
                String product = String.valueOf(c.getString(1));  // Ensure explicit conversion to String
                String price = String.valueOf(c.getString(2));    // Ensure explicit conversion to String
                arr.add(product + " " + price);  // Concatenate product and price
            } while (c.moveToNext());
        }

        db.close();
        return arr;
    }

    public void addToOrder(String username, String product, String price, String name, String address, String phone, String email) {
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("product", product);
        cv.put("price", price);
        cv.put("name", name);
        cv.put("address", address);
        cv.put("phone", phone);
        cv.put("email", email);

        try {
            SQLiteDatabase db = getWritableDatabase();
            db.insert("orders", null, cv);
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ArrayList<String> getOrders(String username) {
        ArrayList<String> arr = new ArrayList<>();
        String str[] = new String[1];
        str[0] = username;
        SQLiteDatabase db = getReadableDatabase();

        try {
            Cursor c = db.rawQuery("select * from orders where username=?", str);
            Log.e("arr", c.toString());

            if (c.moveToFirst()) {
                do {
                    // Ensure that you are using correct column indices (starting from 0)
                    String usernamee = String.valueOf(c.getString(0)); // column index 0
                    String product_number = String.valueOf(c.getString(1)); // column index 1
                    String price = String.valueOf(c.getString(2)); // column index 2
                    String name = String.valueOf(c.getString(3)); // column index 3
                    String address = String.valueOf(c.getString(4)); // column index 4
                    String phone = String.valueOf(c.getString(5)); // column index 5
                    String email = String.valueOf(c.getString(6)); // column index 6

                    arr.add( product_number + " " + price + " " + name + " " + address + " " + phone + " " + email);
                } while (c.moveToNext());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }

        return arr;
    }


}
