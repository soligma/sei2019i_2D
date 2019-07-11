package com.example.photoeditor.businessLogic.controllers;

import android.util.Log;

import com.example.photoeditor.dataAcces.repositories.UserRepository;

public class PermissionController {

        private UserRepository userR;

        public PermissionController() {
            this.userR = new UserRepository();
        }

        public static int binaryStringToInt(String binary) {
            int num = 0, p = 0;
            if (binary.matches("[10]*")) {
                for (int i = binary.length() - 1; i >= 0; i--) {
                    if (binary.toCharArray()[i] == '1') {
                        num += Math.pow(2, p);
                    }
                    p++;
                }
            }
            return num;
        }

        public boolean updatePermissionsFromInput(String[] perms){
            int cam=0,file=0;
            if(perms.length<2){
                Log.e("error: ", "index out of bounds");
                return false;
            }else{
                cam=binaryStringToInt(perms[0]);
                file=binaryStringToInt(perms[1]);
                if(cam>15)
                    cam=15;
                if(file>15)
                    file=15;
                return userR.updateUserPermissions(cam,file);
            }
        }
    }

