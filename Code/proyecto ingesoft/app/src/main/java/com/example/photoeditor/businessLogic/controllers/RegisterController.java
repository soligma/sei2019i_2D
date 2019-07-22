package com.example.photoeditor.businessLogic.controllers;

import android.util.Log;

import com.example.photoeditor.dataAcces.models.User;
import com.example.photoeditor.dataAcces.repositories.UserRepository;

public class RegisterController {
    UserRepository user = new UserRepository();


    public boolean Register(String username, String password){

        if(user.insertUser(username,password)){
            User oldUser=user.getuserByName("TomCat");
            if(oldUser.getPermissionCam()!=15 || oldUser.getPermissionFile()!=15)
                user.updateUserPermissions(oldUser.getPermissionCam(),oldUser.getPermissionFile());
            Log.d("STATE","It works, info created: " + username + " , " + password);
            return true;
        }else{
            Log.d("STATE","It doesn't work, info created: " + username + " , " + password);
            return false;
        }
    }
}
