package com.example.photoeditor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.user_log1);
        password = findViewById(R.id.password_log1);
    }

    public void buttonLogin(View view){
        String user_log = username.getText().toString();
        String pw_log = password.getText().toString();
        if(user_log.length() == 0){
            Toast.makeText(this, "You must enter an username", Toast.LENGTH_SHORT).show();
        }
        if(pw_log.length() == 0){
            Toast.makeText(this, "You must enter a password", Toast.LENGTH_SHORT).show();
        }

        if(user_log.length() != 0 && pw_log.length() != 0 ){
            Toast.makeText(this, "Validated fields but this function still doesn't works", Toast.LENGTH_SHORT).show();
            if(true){ //si el usuario es un usuario general
                Intent principal = new Intent(this,GalleryActivity.class);
                startActivity(principal);
            }else{ //si el usuario es un administrador
                Intent admin = new Intent(this,PermissionActivity.class);
                startActivity(admin);
            }
        }
    }
}
