package com.example.photoeditor.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.photoeditor.R;

public class PermissionActivity extends AppCompatActivity {

    private CheckBox check1,check2,check3,check4,check5,check6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        getSupportActionBar().hide();
        check1 = findViewById(R.id.check_f1);
        check2 = findViewById(R.id.check_f2);
        check3 = findViewById(R.id.check_f3);
        check4 = findViewById(R.id.check_f4);
        check5 = findViewById(R.id.check_f5);
        check6 = findViewById(R.id.check_f6);
    }

    public void save(View view){
        String notify = "";
        if(check1.isChecked() == true){
            notify = "The filter 1 has been applied";
        }
        if(check2.isChecked() == true){
            notify = "The filter 2 has been applied";
        }
        if(check3.isChecked() == true){
            notify = "The filter 3 has been applied";
        }
        if(check4.isChecked() == true){
            notify = "The filter 4 has been applied";
        }
        if(check5.isChecked() == true){
            notify = "The filter 5 has been applied";
        }
        if(check6.isChecked() == true){
            notify = "The filter 6 has been applied";
        }
        Toast.makeText(this,notify,Toast.LENGTH_LONG).show();
    }
}
