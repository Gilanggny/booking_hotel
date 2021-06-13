package com.hotel.restapi.model;

public class RegisUser {
    private String name;
    private String phone;
    private String address;
    private String username;
    private String email;
    private String password;

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
    public void setPhone(String input){this.phone = input;}

    public String getName(){return name;}
    public String getAddress(){return address;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}
    public String getPhone(){return phone;}
    public String getUsername(){return username;}

}
