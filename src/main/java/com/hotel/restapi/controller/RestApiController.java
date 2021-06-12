package com.hotel.restapi.controller;


import com.hotel.restapi.model.Hotel;
import com.hotel.restapi.model.OrderHotel;
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
        logger.info("Sending information of new user : {}", RequestHotel);
        sendOrder.orderHotel(RequestHotel);
        return new ResponseEntity<>(receiveInfo.receiveOrderRespondFromDB(), HttpStatus.CREATED);
    }



}
