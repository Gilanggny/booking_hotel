package com.hotel.database;

import com.hotel.database.dbresponse.receive;

public class databaseApp {
    public static void main(String[] args){
        receive terima = new receive();
        try{
            terima.requestLisData();
            terima.orderHotel();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
