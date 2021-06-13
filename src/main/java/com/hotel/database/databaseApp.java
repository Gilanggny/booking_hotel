package com.hotel.database;

import com.hotel.database.dbresponse.receive;

public class databaseApp {
    public static void main(String[] args){
        receive terima = new receive();
        try{
            terima.requestLisData();
            terima.orderHotel();
            terima.registerUser();
            terima.loginUser();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
