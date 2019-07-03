package com.absingh.photoApp.ui;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.absingh.photoApp.R;
import com.absingh.photoApp.businessLogic.controllers.LoginController;
import com.absingh.photoApp.businessLogic.controllers.RegisterController;
import com.absingh.photoApp.dataAcces.models.User;
import com.absingh.photoApp.dataAcces.repositories.UserRepository;

public class MainActivity extends AppCompatActivity {
    UserRepository utili=new UserRepository();
    LoginController controller = new LoginController();
    RegisterController Rcontroller = new RegisterController();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 27) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        TextView tv = (TextView) findViewById(R.id.hello);
        try {
            Rcontroller.Register("PruebaTom", "qwerty");
            controller.Login("PruebaTom","qwerty");

            User user=utili.getuserByName("PruebaTom");

            tv.setText("Username: " + user.getName()+ "Password: " +user.getPassword());

        } catch (Exception e) {

            Toast.makeText(MainActivity.this, "" + e,Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            tv.setText(e.toString());
        }
    }
}