package com.example.photoeditor.dataAcces.models;

public class User {
    private String name;
    private String password;
    private boolean role;
    private int permissionCam;
    private int permissionFile;

    public User(String name,String password,int role, int permissionCam, int permissionFile){
        this.name=name;
        this.password=password;
        if(role==0)
            this.role=false;
        else
            this.role=true;
        this.permissionCam = permissionCam;
        this.permissionFile = permissionFile;
    }

    public int getPermissionCam() {
        return permissionCam;
    }

    public void setPermissionCam(int permissionCam) {
        this.permissionCam = permissionCam;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return this.role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public int getPermissionFile() {
        return permissionFile;
    }

    public void setPermissionFile(int permissionFile) {
        this.permissionFile = permissionFile;
    }

    //traduce los permisos a bits dependiendo del binario, el parámetro indica si son permisos de cámara o archivo
    public boolean[] traductPermissions(boolean camera){
        boolean[] perms=new boolean[4];
        int i=0;
        String binary="";
        if(camera)
            binary=Integer.toBinaryString(this.permissionCam);
        else
            binary=Integer.toBinaryString(this.permissionFile);
        System.out.println(binary);
        binary.trim();
        if(binary.length()==3){
            binary="0"+binary;
        }else if(binary.length()==2){
            binary="00"+binary;
        }if(binary.length()==1){
            binary="000"+binary;
        }
        for(char a:binary.toCharArray()){
            if(a=='1') {
                perms[i] = true;
            }else{
                perms[i] = false;
            }
            i++;
        }
        return perms;
    }
}
