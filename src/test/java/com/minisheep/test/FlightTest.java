package com.minisheep.test;

import com.minisheep.model.BaseFlightInfo;
import com.minisheep.service.FlightService;
import com.minisheep.service.impl.FlightServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minisheep on 18/1/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration
@WebAppConfiguration
public class FlightTest {
//    protected static Logger logger = (Logger) LoggerFactory.getLogger(FlightTest.class);

    @Autowired
    FlightService flightService;

    @Test
    public void getFlightList(){
        List<BaseFlightInfo> flights =  flightService.flightSearch("806");
//        logger.info(String.valueOf(flights));
    }
}
