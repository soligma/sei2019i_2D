package com.absingh.photoApp.dataAcces.repositories;

import android.util.Log;

import com.absingh.photoApp.dataAcces.databases.AsyncCUD;
import com.absingh.photoApp.dataAcces.databases.AsyncQuery;
import com.absingh.photoApp.dataAcces.databases.SQLHelper;
import com.absingh.photoApp.dataAcces.models.User;

import java.util.ArrayList;

public class UserRepository {
    User user;

    public UserRepository() {
        this.user = null;
    }

    public User getUser() {
        return user;
    }

    public User getuserByName(String name){ //read
        ArrayList<String> res;
        try{
            String[] datos = new String[]{"SELECT * from "+ SQLHelper.usr +".User WHERE username='"+name+"'"};
            res= new AsyncQuery().execute(datos).get();

            String[] splint=new String[0];
            if (res.size()>0)
                splint=res.get(0).split(" ");
            String sup="";
            for (int i=0;i<splint.length;i++){
                splint[i].trim();
            }
            if(splint!=null&&splint.length>0){
                this.user=new User(splint[0],splint[1],Integer.parseInt(splint[2]),Integer.parseInt(splint[3]),Integer.parseInt(splint[4]));
            }
        }catch(Exception ex)
        {
            Log.d("failure in query", ex.getMessage());
        }
        return this.user;
    }

    public boolean insertUser(String name, String password){ //create
        boolean succes=false;
        try
        {
            Class.forName(SQLHelper.driver).newInstance();
            String[] datos = new String[]{"insert into "+SQLHelper.usr+".User(username,password) values ('"+name+"', '"+password+"')"};
            succes = new AsyncCUD().execute(datos).get();
            this.user=new User(name,password,0,15,15);
        }catch(Exception ex)
        {
            Log.d("failure in insert", ex.getMessage());
        }
        return succes;
    }

    public boolean updateUserPermissions(int permCam, int permFile){ //update
        boolean succes=false;
        try
        {
            Class.forName(SQLHelper.driver).newInstance();
            String[] datos = new String[]{"update "+SQLHelper.usr+".User set permissionsCam="+permCam+",permissionsFile="+permFile};
            succes = new AsyncCUD().execute(datos).get();
            this.user.setPermissionCam(permCam);
            this.user.setPermissionFile(permFile);
        }catch(Exception ex)
        {
            Log.d("failure in update", ex.getMessage());
        }
        return succes;
    }

    public boolean deleteUserByName(String user){ //delete
        boolean succes=false;
        try
        {
            Class.forName(SQLHelper.driver).newInstance();
            String[] datos = new String[]{"delete from "+SQLHelper.usr+".User where username='"+user+"'"};
            succes = new AsyncCUD().execute(datos).get();
            this.user=null;
        }catch(Exception ex)
        {
            Log.d("failure in delete", ex.getMessage());
        }
        return succes;
    }
}
