package com.example.photoeditor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
    }
    public void toPhoto(View view){
        Intent cancel = new Intent(this,PhotoActivity.class);
        startActivity(cancel);
    }
}