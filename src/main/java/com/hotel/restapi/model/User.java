package com.hotel.restapi.model;

public class User {
    private String name;
    private String phone;
    private String address;
    private String username;
    private String email;
    private String password;
    private boolean status = false;
    private String avatar = "https://cdn1.iconfinder.com/data/icons/mix-color-4/502/Untitled-1-512.png";

    public void setName(String input){
        this.name = input;
    }
    public void setPhone(String input){this.phone=input;}
    public void setAddress(String input){
        this.address = input;
    }
    public void setEmail(String input){
        this.email = input;
    }
    public void setPassword(String input){
        this.password = input;
    }
    public void setUsername(String input){this.username = input;}
    public void setAvatar(String input){this.avatar = input;}

    public String getName(){return name;}
    public String getPhone(){return phone;}
    public String getAddress(){return address;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}
    public String getUsername(){return username;}
    public boolean getStatus(){return status;}
    public String getAvatar(){return avatar;}

    public void changeStatus(){
        if(status==true){
            this.status = false;
        } else {
            this.status = true;
        }
    }
}
