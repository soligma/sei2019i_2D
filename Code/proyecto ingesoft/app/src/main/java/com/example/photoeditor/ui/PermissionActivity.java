package com.example.photoeditor.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.photoeditor.R;
import com.example.photoeditor.businessLogic.controllers.PermissionController;

public class PermissionActivity extends AppCompatActivity {

    PermissionController p1 = new PermissionController();
    private CheckBox check1,check2,check3,check4,check5,check6, check7, check8;
    boolean c1,c2,c3,c4,c5,c6,c7,c8;
    String cameraFilter = "" ;
    String galleryFilter = "";

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

    public String[] permissionWriter() {
        if(check1.isChecked()){
            c1 = true;
            cameraFilter += "1";
        }else{
            c1 = false;
            cameraFilter += "0";
        }
        if(check2.isChecked()){
            c2 = true;
            cameraFilter += "1";
        }else{
            c2 = false;
            cameraFilter += "0";
        }
        if(check3.isChecked()){
            c3 = true;
            cameraFilter += "1";
        }else{
            c3 = false;
            cameraFilter += "0";
        }
        if(check4.isChecked()){
            c4 = true;
            cameraFilter += "1";
        }else{
            c4 = false;
            cameraFilter += "0";
        }
        if(check5.isChecked()){
            c5 = true;
            galleryFilter += "1";
        }else{
            c5 = false;
            galleryFilter += "0";
        }
        if(check6.isChecked()){
            c6 = true;
            galleryFilter += "1";
        }else{
            c6 = false;
            galleryFilter += "0";
        }
        if(check7.isChecked()){
            c7 = true;
            galleryFilter += "1";
        }else{
            c7 = false;
            galleryFilter += "0";
        }
        if(check8.isChecked()){
            c8 = true;
            galleryFilter += "1";
        }else{
            c8 = false;
            galleryFilter += "0";
        }
        String [] permissionsCG= {cameraFilter, galleryFilter};
        return permissionsCG;
    }

    public void buttonSave(View view){

        //----------------------------------funcion implementada por data acces-----------------------------------

        p1.updatePermissionsFromInput(permissionWriter());

        Toast.makeText(this, "Changes has been aplied", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,LoginActivity.class));
        finish();
    }
}
