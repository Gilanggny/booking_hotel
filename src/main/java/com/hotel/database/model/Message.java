package com.hotel.database.model;

public class Message {
    private String message;

    public Message(String inputMessage){
        this.message = inputMessage;
    }

    public void setMessage(String input){
        this.message = input;
    }

    public String getMessage(){
        return message;
    }
}
