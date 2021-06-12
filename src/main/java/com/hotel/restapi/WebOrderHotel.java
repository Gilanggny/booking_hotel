package com.hotel.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class WebOrderHotel {
    public static void main(String[] args){
        SpringApplication application = new SpringApplication(WebOrderHotel.class);
        application.setDefaultProperties(Collections.singletonMap("server.port", "8887"));
        application.run(args);

        try {

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
