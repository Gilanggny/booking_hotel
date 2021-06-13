package com.hotel.restapi.controller;


import com.hotel.restapi.model.*;
import com.hotel.restapi.response.receive;
import com.hotel.restapi.response.send;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

@RestController
@CrossOrigin
@RequestMapping("/web/hotel")
public class RestApiController {
    private static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
    send sendOrder = new send();
    receive receiveInfo = new receive();

    //------------------------------------------------------------------------------------------------------
    //                                         REQUEST LIST DATA
    //------------------------------------------------------------------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<?> displayHotel() throws SQLException, IOException, TimeoutException {
        logger.info("Sending information to show the hotel list ");
        sendOrder.listHotel();
        return new ResponseEntity<>(receiveInfo.receiveHotelListFromDB(), HttpStatus.CREATED);
    }

    //------------------------------------------------------------------------------------------------------
    //                                          BOOKING KAMAR HOTEL
    //------------------------------------------------------------------------------------------------------

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ResponseEntity<?> orderHotel(@RequestBody OrderHotel RequestHotel) throws SQLException, IOException, TimeoutException {
        logger.info("Sending information of new order : {}", RequestHotel);
        sendOrder.orderHotel(RequestHotel);
        return new ResponseEntity<>(receiveInfo.receiveOrderRespondFromDB(), HttpStatus.CREATED);
    }

    //------------------------------------------------------------------------------------------------------
    //                                              REGISTER USER
    //------------------------------------------------------------------------------------------------------

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody User newUser) throws SQLException, IOException, TimeoutException {
        logger.info("Sending information of new user : {}", newUser);
        sendOrder.registerUser(newUser);
        return new ResponseEntity<>(receiveInfo.receiveRegisterUserRespondFromDB(), HttpStatus.CREATED);
    }

    //------------------------------------------------------------------------------------------------------
    //                                                LOGIN USER
    //------------------------------------------------------------------------------------------------------

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestBody User loginUser) throws SQLException, IOException, TimeoutException {
        logger.info("Sending information of new user : {}", loginUser);
        sendOrder.loginUser(loginUser);
        return new ResponseEntity<>(receiveInfo.receiveLoginUserRespondFromDB(), HttpStatus.CREATED);
    }

}
