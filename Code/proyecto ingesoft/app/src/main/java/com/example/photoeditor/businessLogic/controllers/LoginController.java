package com.example.photoeditor.businessLogic.controllers;

import android.util.Log;

import com.example.photoeditor.dataAcces.models.User;
import com.example.photoeditor.dataAcces.repositories.UserRepository;

public class LoginController {
    UserRepository user = new UserRepository();

    public User getUser(){
        return this.user.getUser();
    }

    public int Login(String username, String Password){
        User temp = user.getuserByName(username);
        String pass;

        pass = temp.getPassword();

        if(Password.equals(pass) ){
            Log.d("STATE","It works");
            if(temp.isAdmin()){
                return 1;
            }
            else {
                return 2;
            }
        }else{
            Log.d("STATE","It doesn't work");
            return 0;
        }
    }
}
