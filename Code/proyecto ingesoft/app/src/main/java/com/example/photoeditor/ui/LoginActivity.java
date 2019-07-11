package com.example.photoeditor.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.photoeditor.R;
import com.example.photoeditor.businessLogic.controllers.LoginController;

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


        if(user_log.length() == 0 || pw_log.length() == 0){
            Toast.makeText(this, "El campo de usuario o contraseña esta vacio", Toast.LENGTH_SHORT).show();
        }else{
            if(loginController.Login(user_log, pw_log) != 0){
                if(loginController.Login(user_log, pw_log) == 2){ //si el usuario es un usuario general
                    Intent principal = new Intent(this,GalleryActivity.class);
                    startActivity(principal);
                }else if(loginController.Login(user_log, pw_log) == 1){ //si el usuario es un administrador
                    Intent admin = new Intent(this,PermissionActivity.class);
                    startActivity(admin);
                }
            }else{
                Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void register(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
        overridePendingTransition(R.transition.fade_in,R.transition.fade_out);
    }
}
