package com.hotel.restapi.response;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.GetResponse;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class receive {

    public String receiveHotelListFromDB() throws IOException, TimeoutException {
        ConnectionFactory conFac = new ConnectionFactory();
        conFac.setHost("localhost");
        Connection con = conFac.newConnection();
        Channel ch = con.createChannel();

        ch.queueDeclare("hotelListFromDB", false, false, false, null);

        GetResponse getResponse;
        do { getResponse = ch.basicGet("hotelListFromDB", true); } while (getResponse==null);

        String message = new String(getResponse.getBody(), "UTF-8");

        System.out.println(" [x] Received User List Data From RabbitMQ");

        return message;
    }

    public String receiveOrderRespondFromDB() throws IOException, TimeoutException {
        ConnectionFactory conFac = new ConnectionFactory();
        conFac.setHost("localhost");
        Connection con = conFac.newConnection();
        Channel ch = con.createChannel();

        ch.queueDeclare("receiveOrderResponseFromDB", false, false, false, null);

        GetResponse getResponse;
        do { getResponse = ch.basicGet("receiveOrderResponseFromDB", true); } while (getResponse==null);

        String message = new String(getResponse.getBody(), "UTF-8");

        System.out.println(" [x] Received Order Response Data From Database via RabbitMQ");

        return message;
    }

    public String receiveRegisterUserRespondFromDB() throws IOException, TimeoutException {
        ConnectionFactory conFac = new ConnectionFactory();
        conFac.setHost("localhost");
        Connection con = conFac.newConnection();
        Channel ch = con.createChannel();

        ch.queueDeclare("receiveRegisterResponseFromDB", false, false, false, null);

        GetResponse getResponse;
        do { getResponse = ch.basicGet("receiveRegisterResponseFromDB", true); } while (getResponse==null);

        String message = new String(getResponse.getBody(), "UTF-8");

        System.out.println(" [x] Received Order Response Data From Database via RabbitMQ");

        return message;
    }

    public String receiveLoginUserRespondFromDB() throws IOException, TimeoutException {
        ConnectionFactory conFac = new ConnectionFactory();
        conFac.setHost("localhost");
        Connection con = conFac.newConnection();
        Channel ch = con.createChannel();

        ch.queueDeclare("receiveLoginResponseFromDB", false, false, false, null);

        GetResponse getResponse;
        do { getResponse = ch.basicGet("receiveLoginResponseFromDB", true); } while (getResponse==null);

        String message = new String(getResponse.getBody(), "UTF-8");

        System.out.println(" [x] Received Order Response Data From Database via RabbitMQ");

        return message;
    }
}
