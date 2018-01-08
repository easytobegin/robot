package com.minisheep.controller;

import com.minisheep.model.BaseFlightInfo;
import com.minisheep.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by minisheep on 18/1/6.
 */
@RestController
@RequestMapping({"/query"})
public class BaseAirlinesController {
    @Autowired
    FlightService flightService;

    @RequestMapping("/abc")
    public List<BaseFlightInfo> getFlightList(){
        List<BaseFlightInfo> flights =  flightService.flightSearch("806");
//        logger.info(String.valueOf(flights));
        return flights;
    }
}
