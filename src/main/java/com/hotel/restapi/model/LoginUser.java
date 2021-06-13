package com.hotel.restapi.model;

public class LoginUser {
    private String name;
    private String address;
    private String email;
    private String username;
    private String password;
    private boolean status = false;

    public void setName(String input){
        this.name = input;
    }
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

    public String getName(){return name;}
    public String getAddress(){return address;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}
    public String getUsername(){return username;}

    public void changeStatus(){
        this.status = true;
    }

}
