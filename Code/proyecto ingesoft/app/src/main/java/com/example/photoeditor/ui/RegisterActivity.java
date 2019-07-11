package com.example.photoeditor.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.photoeditor.R;
import com.example.photoeditor.businessLogic.controllers.RegisterController;

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
            Toast.makeText(this, "You must enter a username", Toast.LENGTH_SHORT).show();
        }else if(value4.length() == 0){
            Toast.makeText(this, "You must enter a password", Toast.LENGTH_SHORT).show();
        }

        if(registerController.Register(value2, value4) && (value2.length() > 0 && value4.length()> 0)){
            Toast.makeText(this, "Successful registration. You can login\n", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity.class));
        }
    }


}
