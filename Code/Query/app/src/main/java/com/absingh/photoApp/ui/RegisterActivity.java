package com.absingh.photoApp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.absingh.photoApp.R;

import com.absingh.photoApp.businessLogic.controllers.*;

public class RegisterActivity extends AppCompatActivity {

    private EditText username_reg;
    private EditText pw_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        username_reg = findViewById(R.id.user_reg);
        pw_reg = findViewById(R.id.pw_reg);
    }

    public void buttonRegister(View view){

        String value2 = username_reg.getText().toString();
        String value4 = pw_reg.getText().toString();

        RegisterController registerController = new RegisterController();

        if(value2.length() == 0){
            Toast.makeText(this, "Debe ingresar un nombre de usuario.", Toast.LENGTH_SHORT).show();
        }else if(value4.length() == 0){
            Toast.makeText(this, "Debe ingresar una contaseña.", Toast.LENGTH_SHORT).show();
        }

        if(registerController.Register(value2, value4) && (value2.length() > 0 && value4.length()> 0)){
            Toast.makeText(this, "Registro completo. Puede iniciar sesión", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity.class));
        }
    }


}
