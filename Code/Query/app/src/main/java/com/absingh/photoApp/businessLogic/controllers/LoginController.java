package com.absingh.photoApp.businessLogic.controllers;

import android.util.Log;

import com.absingh.photoApp.dataAcces.models.User;
import com.absingh.photoApp.dataAcces.repositories.UserRepository;

public class LoginController {
    UserRepository user = new UserRepository();


    public boolean Login(String username, String Password){
        User temp = user.getuserByName(username);
        String pass;

        pass = temp.getPassword();

        if(Password.equals(pass) ){
            Log.d("STATE","It works");
            return true;
        }else{
            Log.d("STATE","It doesn't work");
            return false;
        }
    }
}
