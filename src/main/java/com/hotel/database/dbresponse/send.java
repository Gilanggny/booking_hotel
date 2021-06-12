package com.hotel.database.dbresponse;

import com.google.gson.Gson;
import com.hotel.database.model.Hotel;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class send {
    private ConnectionFactory connectionFactory;

    // Send ListUser Data To RestAPI
    public void sendListUserToRestController(List<Hotel> hotelList){
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");

        try (
                Connection con = connectionFactory.newConnection();
                Channel channel = con.createChannel();
        ) {
            channel.queueDeclare("hotelListFromDB", false, false, false, null);

            String ListJSON = new Gson().toJson(hotelList);

            channel.basicPublish(
                    "",
                    "hotelListFromDB",
                    null,
                    ListJSON.getBytes(StandardCharsets.UTF_8)
            );

            System.out.println("Sent Hotel List To Rabbit MQ");

        } catch(Exception e){
            e.printStackTrace();
        }
    }

}
