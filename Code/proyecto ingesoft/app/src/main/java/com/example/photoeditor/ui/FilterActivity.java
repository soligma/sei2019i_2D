package com.example.photoeditor.ui;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.photoeditor.R;

import java.io.File;
import java.io.FileOutputStream;

public class FilterActivity extends AppCompatActivity {
	
	final int RequestPermissionCode = 1;
	final int GALLERY_CODE = 10;
	final int PHOTO_CODE = 20;
	final int CROP_CODE = 30;
	ImageView iv;
	Bitmap bitmap;
	Uri uri;
	String currentImage = "";
	
	boolean[] boolCamera = LoginActivity.loggedUser.traductPermissions(true);
	boolean[] boolGallery = LoginActivity.loggedUser.traductPermissions(false);
	boolean use;
	
	private static Bitmap getScreenShot(View view) {
		view.setDrawingCacheEnabled(true);
		Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
		view.setDrawingCacheEnabled(false);
		return bitmap;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_filter);
		getSupportActionBar().hide();
		iv = findViewById(R.id.photo);
		use = catchDAta();
	}
	
	public boolean catchDAta() {
		Bundle extras = getIntent().getExtras();
		boolean bool1 = extras.getBoolean("v1");
		if (bool1) {
			uploadImage();
		} else {
			takePhoto();
		}
		return bool1;
	}
	
	private void uploadImage() {
		Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		intent.setType("image/");
		startActivityForResult(intent.createChooser(intent, "Choose the app"), GALLERY_CODE);
	}
	
	private void takePhoto() {
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(intent, PHOTO_CODE);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (data != null) {
			switch (requestCode) {
				case GALLERY_CODE:
					uri = data.getData();
					iv.setImageURI(uri);
					break;
				
				case PHOTO_CODE:
					Bitmap bitmap = (Bitmap) data.getExtras().get("data");
					iv.setImageBitmap(bitmap);
					break;
				
				case CROP_CODE:
					uri = data.getData();
					iv.setImageURI(uri);
					break;
			}
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		switch (requestCode) {
			case RequestPermissionCode:
				if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
					Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(this, "Permission Canceled", Toast.LENGTH_SHORT).show();
				}
				break;
		}
	}
	
	//funciones para los filtros
	public void buttonFilter1(View view) {
		if (this.use) {
			if (boolGallery[0]) {
				BlackAndWhite();
			} else {
				Toast.makeText(this, "black and white is unavailabel for the gallery", Toast.LENGTH_SHORT).show();
			}
		} else {
			if (boolCamera[0]) {
				BlackAndWhite();
			} else {
				Toast.makeText(this, "black and white is unavailable for the camera", Toast.LENGTH_SHORT).show();
			}
		}
	}
	
	private void BlackAndWhite() {
		View content = findViewById(R.id.photo);
		ColorMatrix colorMatrix = new ColorMatrix();
		colorMatrix.setSaturation(0);
		iv.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
		bitmap = getScreenShot(content);
	}
	
	public void buttonFilter2(View view) {
		if (this.use) {
			if (boolGallery[1]) {
				filterSemiTransaparent();
			} else {
				Toast.makeText(this, "semi transparent is unavailabel for the gallery", Toast.LENGTH_SHORT).show();
			}
		} else {
			if (boolCamera[1]) {
				filterSemiTransaparent();
			} else {
				Toast.makeText(this, "semi transparent is unavailable for the camera", Toast.LENGTH_SHORT).show();
			}
		}
	}
	
	private void filterSemiTransaparent() {
		View content = findViewById(R.id.photo);
		iv.setColorFilter(Color.argb(150, 155, 155, 155), PorterDuff.Mode.SRC_ATOP);
		bitmap = getScreenShot(content);
	}
	
	public void buttonFilter3(View view) {
		if (this.use) {
			if (boolGallery[2]) {
				filterPink();
			} else {
				Toast.makeText(this, "pink is unavailabel for the gallery", Toast.LENGTH_SHORT).show();
			}
		} else {
			if (boolCamera[2]) {
				filterPink();
			} else {
				Toast.makeText(this, "pink is unavailable for the camera", Toast.LENGTH_SHORT).show();
			}
		}
	}
	
	private void filterPink() {
		View content = findViewById(R.id.photo);
		iv.setColorFilter(new LightingColorFilter(Color.WHITE, 0xFF4081));
		bitmap = getScreenShot(content);
	}
	
	public void buttonFilter4(View view) {
		if (this.use) {
			if (boolGallery[3]) {
				filterBlue();
			} else {
				Toast.makeText(this, "blue is unavailabel for the gallery", Toast.LENGTH_SHORT).show();
			}
		} else {
			if (boolCamera[3]) {
				filterBlue();
			} else {
				Toast.makeText(this, "blue is unavailable for the camera", Toast.LENGTH_SHORT).show();
			}
		}
	}
	
	private void filterBlue() {
		View content = findViewById(R.id.photo);
		Paint paint = new Paint();
		
		int ini = Color.argb(125, 14  ,90, 232);
		
		int progressendcolor = Color.argb(76,14,30,39);
		
		LinearGradient linearGradient = new LinearGradient(0, 0, iv.getWidth(), iv.getHeight(), ini, progressendcolor, Shader.TileMode.CLAMP);
		paint.setShader(linearGradient);
		Canvas canvas = new Canvas(bitmap);
		canvas.drawBitmap(bitmap, 0,0, paint);
		bitmap = getScreenShot(content);
	}
	
	public void cropButton(View view) {
		if (this.use) {
			if (boolGallery[3]) {
				cropImage();
			} else {
				Toast.makeText(this, "crop is unavailabel for the gallery", Toast.LENGTH_SHORT).show();
			}
		} else {
			if (boolCamera[3]) {
				cropImage();
			} else {
				Toast.makeText(this, "crop is unavailable for the camera", Toast.LENGTH_SHORT).show();
			}
		}
	}
	
	private void cropImage() {
		try {
			Intent cropIntent = new Intent("com.android.camera.action.CROP");
			cropIntent.setDataAndType(uri, "image/*");
			
			cropIntent.putExtra("crop", "true");
			cropIntent.putExtra("outputX", 180);
			cropIntent.putExtra("outputY", 180);
			cropIntent.putExtra("aspectX", 3);
			cropIntent.putExtra("aspectY", 4);
			cropIntent.putExtra("scaleUpIfNeeded", true);
			cropIntent.putExtra("return-data", true);
			startActivityForResult(cropIntent, CROP_CODE);
			
		} catch (ActivityNotFoundException ex) {
		
		}
	}
	
	private void store(Bitmap bm, String fileName) {
		String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Soligma";
		File dir = new File(dirPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dirPath, fileName);
		try {
			FileOutputStream fos = new FileOutputStream(file);
			bm.compress(Bitmap.CompressFormat.PNG, 100, fos);
			fos.flush();
			fos.close();
			Toast.makeText(this, "Image saved successfully in Soligma's folder", Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buttonSaveChanges(View view) {
		View content = findViewById(R.id.photo);
		Bitmap bitmap = getScreenShot(content);
		currentImage = "image" + System.currentTimeMillis() / 1000 + ".jpg";
		store(bitmap, currentImage);
	}
	
	public void Cancel(View view) {
		iv.clearColorFilter();
	}
}
