package com.example.photoeditor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
    }
    public void camera(View view){
        Intent camswap = new Intent(this,PhotoActivity.class);
        startActivity(camswap);
    }
}