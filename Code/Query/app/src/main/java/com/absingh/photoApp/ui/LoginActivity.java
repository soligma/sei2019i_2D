package com.absingh.photoApp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.absingh.photoApp.R;

import com.absingh.photoApp.businessLogic.controllers.*;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        username = findViewById(R.id.user_log1);
        password = findViewById(R.id.password_log1);
    }



    public void buttonLogin(View view){
        String user_log = username.getText().toString();
        String pw_log = password.getText().toString();

        LoginController loginController = new LoginController();


        if(user_log.length() == 0){
            Toast.makeText(this, "You must enter an username", Toast.LENGTH_SHORT).show();
        }
        if(pw_log.length() == 0){
            Toast.makeText(this, "You must enter a password", Toast.LENGTH_SHORT).show();
        }

        if(loginController.Login(user_log, pw_log)){
            if(true){ //si el usuario es un usuario general
                Intent principal = new Intent(this,GalleryActivity.class);
                startActivity(principal);
            }else{ //si el usuario es un administrador
                Intent admin = new Intent(this,PermissionActivity.class);
                startActivity(admin);
            }
        }else{
            Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show();
        }
    }

    public void register(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
