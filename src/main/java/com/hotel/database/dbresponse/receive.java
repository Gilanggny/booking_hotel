package com.hotel.database.dbresponse;

import com.hotel.database.repository.hotelRepository;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class receive {
    private ConnectionFactory connectionFactory;
    private Connection con;
    private Channel ch;

    hotelRepository HotelRep = new hotelRepository();

    public void connectRabbit() throws IOException, TimeoutException {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        con = connectionFactory.newConnection();
    }

    // Get Order To Request List Data From RestAPI
    public void requestLisData(){
        try{
            connectRabbit();
            ch = con.createChannel();
            ch.queueDeclare("requestDataHotel", false, false, false, null);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {

                System.out.println(" [x] Received Message From RabbitMQ");
                try{
//                    UserRep.requestListUser();
                    HotelRep.requestListHotel();
                } catch(Exception e){
                    e.printStackTrace();
//                    sendMessage.sendInputResponsetoRestController("Gagal");
                }
            };
            ch.basicConsume("requestDataHotel", true, deliverCallback, consumerTag -> { });
        } catch (Exception e){
            e.printStackTrace();
            e.printStackTrace();
        }
    }

    // Get Order To Input Order List to DB From RestAPI
    public void orderHotel(){
        try{
            connectRabbit();
            ch = con.createChannel();
            ch.queueDeclare("requestDataHotel", false, false, false, null);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {

                System.out.println(" [x] Received Message From RabbitMQ");
                try{
//                    HotelRep.requestListHotel();
                    
                } catch(Exception e){
                    e.printStackTrace();
                }
            };
            ch.basicConsume("requestDataHotel", true, deliverCallback, consumerTag -> { });
        } catch (Exception e){
            e.printStackTrace();
            e.printStackTrace();
        }
    }

}
