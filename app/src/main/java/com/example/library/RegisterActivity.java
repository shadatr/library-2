package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText etUsername, etPassword, etPasswordConf,etEmail;
    TextView login;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etPassword= findViewById(R.id.password);
        etPasswordConf= findViewById(R.id.confpassword);
        etUsername=findViewById(R.id.username);
        etEmail=findViewById(R.id.email);
        register=findViewById(R.id.register);
        login=findViewById(R.id.login);
        Database db=new Database(getApplicationContext(),"library",null,1);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username= etUsername.getText().toString();
                String password= etPassword.getText().toString();
                String passwordConf= etPasswordConf.getText().toString();
                String email= etEmail.getText().toString();

                if(username.length()==0||password.length()==0||email.length()==0||passwordConf.length()==0){
                    Toast.makeText(RegisterActivity.this, "Please fill all details", Toast.LENGTH_SHORT).show();
                }else{
                    if(password.compareTo(passwordConf)==0){
                        if(password.length()<8){
                            Toast.makeText(RegisterActivity.this, "password should be longer than 8", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            db.register(username,password,email);
                            Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));

                        }
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "The passwords didn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }
}