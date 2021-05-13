package com.example.intershalaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username,password;
    Button btnsignin;
    Database DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        btnsignin = findViewById(R.id.buttonSignIn1);
        DB = new Database(this);

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(pass.equals("") || user.equals("")){
                    Toast.makeText(LoginActivity.this,"Please enter all the details!",Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkUserPass = DB.checkUsernamePassword(user,pass);
                    if(checkUserPass == true){
                        Log.i("Succcess","Done");
                        //Toast.makeText(LoginActivity.this,"SignIn Successful",Toast.LENGTH_SHORT).show();
                        //Intent intent = new Intent(getApplicationContext(),homeActivity.class);
                        //startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}