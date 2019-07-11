package com.example.photoeditor.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.photoeditor.R;

import java.io.File;

public class GalleryActivity extends AppCompatActivity {

    boolean b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        getSupportActionBar().hide();
    }


    public void buttonGallery(View view){
        b1 = true;
        Intent in = new Intent(this, FilterActivity.class);
        in.putExtra("v1",b1);
        startActivity(in);
        overridePendingTransition(R.transition.zoom_back_in,R.transition.zoom_back_out);
    }
    public void buttonPhoto(View view){
        b1 = false;
        Intent in = new Intent(this, FilterActivity.class);
        in.putExtra("v1",b1);
        startActivity(in);
        overridePendingTransition(R.transition.zoom_back_in,R.transition.zoom_back_out);
    }



}
