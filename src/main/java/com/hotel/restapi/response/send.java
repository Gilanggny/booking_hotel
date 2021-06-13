package com.hotel.restapi.response;

import com.google.gson.Gson;
import com.hotel.restapi.model.*;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class send {

    // Send Order to Request Hotel List To Database APP
    public void listHotel() throws IOException, TimeoutException {
        ConnectionFactory conFac = new ConnectionFactory();
        conFac.setHost("localhost");
        Connection con = conFac.newConnection();
        Channel channel = con.createChannel();

        String message = "Request Data Hotel";

        try{
            channel.queueDeclare("requestDataHotel", false, false, false, null);
            channel.basicPublish("", "requestDataHotel", null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("[x] Sending Data Request to RabbitMQ");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // Send Order to Input Hotel Order To Database APP
    public void orderHotel(OrderHotel orderHotel) throws IOException, TimeoutException {
        ConnectionFactory conFac = new ConnectionFactory();
        conFac.setHost("localhost");
        Connection con = conFac.newConnection();
        Channel channel = con.createChannel();

        String message = new Gson().toJson(orderHotel);

        try{
            channel.queueDeclare("orderDataHotel", false, false, false, null);
            channel.basicPublish("", "orderDataHotel", null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("[x] Sending Order Hotel to RabbitMQ");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // Send Order to Input Data To Register To Database APP
    public void registerUser(User newUser) throws IOException, TimeoutException {
        ConnectionFactory conFac = new ConnectionFactory();
        conFac.setHost("localhost");
        Connection con = conFac.newConnection();
        Channel channel = con.createChannel();

        String message = new Gson().toJson(newUser);

        try{
            channel.queueDeclare("registerUserHotel", false, false, false, null);
            channel.basicPublish("", "registerUserHotel", null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("[x] Sending Register User to RabbitMQ");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // Send Order to Input Data To Register To Database APP
    public void loginUser(User loginUser) throws IOException, TimeoutException {
        ConnectionFactory conFac = new ConnectionFactory();
        conFac.setHost("localhost");
        Connection con = conFac.newConnection();
        Channel channel = con.createChannel();

        String message = new Gson().toJson(loginUser);

        try{
            channel.queueDeclare("loginUserHotel", false, false, false, null);
            channel.basicPublish("", "loginUserHotel", null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("[x] Sending Register User to RabbitMQ");
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
