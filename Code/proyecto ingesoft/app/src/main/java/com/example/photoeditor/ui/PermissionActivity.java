package com.example.photoeditor.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.photoeditor.R;

public class PermissionActivity extends AppCompatActivity {

    private CheckBox check1,check2,check3,check4,check5,check6, check7, check8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        getSupportActionBar().hide();
        check1 = findViewById(R.id.check_f1);
        check2 = findViewById(R.id.check_f2);
        check3 = findViewById(R.id.check_f3);
        check4 = findViewById(R.id.check_crop1);
        check5 = findViewById(R.id.check_f4);
        check6 = findViewById(R.id.check_f5);
        check7 = findViewById(R.id.check_f6);
        check8 = findViewById(R.id.check_crop2);
    }

    public String[] save(View view){
        boolean bool1,bool2,bool3,bool4,bool5,bool6;
        String cameraFilter = "" ;
        String galleryFilter = "";
        String notify = "";
        if(check1.isChecked()){
            bool1 = true;
            cameraFilter += "1";
            notify = "The filter 1 has been applied";
        }else{
            bool1 = false;
            cameraFilter += "0";
        }
        if(check2.isChecked()){
            notify = "The filter 2 has been applied";
            bool2 = true;
            cameraFilter += "1";
        }else{
            bool2 = false;
            cameraFilter += "0";
        }
        if(check3.isChecked()){
            notify = "The filter 3 has been applied";
            bool3 = true;
            cameraFilter += "1";
        }else{
            bool3 = false;
            cameraFilter += "0";
        }
        if(check4.isChecked()){
            notify = "The filter 4 has been applied";
            bool4 = true;
            cameraFilter += "1";
        }else{
            bool4 = false;
            cameraFilter += "0";
        }
        if(check5.isChecked()){
            notify = "The filter 5 has been applied";
            bool5 = true;
            galleryFilter += "1";
        }else{
            bool5 = false;
            galleryFilter += "0";
        }
        if(check6.isChecked()){
            notify = "The filter 6 has been applied";
            bool6 = true;
            galleryFilter += "1";
        }else{
            bool6 = false;
            galleryFilter += "0";
        }
        if(check7.isChecked()){
            notify = "The filter 7 has been applied";
            bool6 = true;
            galleryFilter += "1";
        }else{
            bool6 = false;
            galleryFilter += "0";
        }
        if(check8.isChecked()){
            notify = "The filter 8 has been applied";
            bool6 = true;
            galleryFilter += "1";
        }else{
            bool6 = false;
            galleryFilter += "0";
        }
        if(notify.length() != 0){
            Toast.makeText(this,notify,Toast.LENGTH_LONG).show();
        }

        String [] save = {cameraFilter, galleryFilter};

        return save;

    }
}
