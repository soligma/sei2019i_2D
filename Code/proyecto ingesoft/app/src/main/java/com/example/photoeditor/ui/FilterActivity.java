package com.example.photoeditor.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.photoeditor.R;


import java.io.File;

public class FilterActivity extends AppCompatActivity {

    private final String ROOT_FOLDER = "myPhotosTest/";
    private final String IMAGE_PATH = ROOT_FOLDER + "myPhotos";
    final int GALLERY_CODE = 10;
    final int PHOTO_CODE = 20;
    String path;
    String imageName = "";
    ImageView iv;

    //arreglo de booleanos que será recibido posteriormente por un controllador de tipo permission
    //boolean[] received = new boolean[7];
    boolean[] received = {false,false,true,true,false,true,false,true};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        getSupportActionBar().hide();
        iv = (ImageView) findViewById(R.id.imageView2);
        catchDAta();
    }

    public void catchDAta(){
        Bundle extras = getIntent().getExtras();
        boolean bool1 = extras.getBoolean("v1");
        if(bool1){
            uploadImage();
        }else{
            takePhoto();
        }
    }


    private void uploadImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"Choose the app"), GALLERY_CODE);
    }

    private void takePhoto() {
        File fileImage = new File(Environment.getExternalStorageDirectory(),IMAGE_PATH);
        boolean isCreated = fileImage.exists();

        if(!isCreated){
            isCreated = fileImage.mkdirs();
        }
        if(isCreated){
            imageName = (System.currentTimeMillis()/1000) + ".jpg";
        }
        path  = Environment.getExternalStorageDirectory() + File.separator + IMAGE_PATH + File.separator + imageName;
        File image = new File(path);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(image));
        startActivityForResult(intent,PHOTO_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case GALLERY_CODE:
                Uri myPath = data.getData();
                iv.setImageURI(myPath);
                break;

            case PHOTO_CODE:
                MediaScannerConnection.scanFile(this, new String[]{path}, null, new MediaScannerConnection.OnScanCompletedListener() {
                    @Override
                    public void onScanCompleted(String path, Uri uri) {
                        Log.i("Storage folder","Path: " + path);
                    }
                }
                );

                Bitmap bitmap = BitmapFactory.decodeFile(path);
                iv.setImageBitmap(bitmap);

                break;
        }
    }

    //funciones para los filtros


    public void buttonFilter1(View view){
        String msg = "";
        if(received[0]){//funcionalidad del filtro 1 para la camara
            msg = "filter 1 is available for the camera";
        }else{
            msg = "filter 1 is  unavailable for the camera";
        }
        if(received[4]){//funcionalidad del filtro 1 para la galeria
            msg = msg + " and available for the gallery";
        }else{
            msg = msg + " and unavailable for the gallery";
        }
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
    }

    public void buttonFilter2(View view){
        String msg = "";
        if(received[1]){//funcionalidad del filtro 2 para la camara
            msg = "filter 2 is available for the camera";
        }else{
            msg = "filter 2 is  unavailable for the camera";
        }
        if(received[5]){//funcionalidad del filtro 2 para la galeria
            msg = msg + " and available for the gallery";
        }else{
            msg = msg + " and unavailable for the gallery";
        }
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
    }

    public void buttonFilter3(View view){
        String msg = "";
        if(received[2]){//funcionalidad del filtro 3 para la camara
            msg = "filter 3 is available for the camera";
        }else{
            msg = "filter 3 is  unavailable for the camera";
        }
        if(received[6]){//funcionalidad del filtro 3 para la galeria
            msg = msg + " and available for the gallery";
        }else{
            msg = msg + " and unavailable for the gallery";
        }
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
    }

    public void cropButton(View view){
        String msg = "";
        if(received[3]){//funcionalidad del crop para la camara
            msg = " crop filter is available for the camera";
        }else{
            msg = "crop filter is unavailable for the camera";
        }
        if(received[7]){//funcionalidad del crop para la galeria
            msg = msg + " and available for the gallery";
        }else{
            msg = msg + " and unavailable for the gallery";
        }
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
    }
}
