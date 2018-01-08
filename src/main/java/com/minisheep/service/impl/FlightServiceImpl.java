package com.minisheep.service.impl;

import com.minisheep.mapper.FlightMapper;
import com.minisheep.model.BaseFlightInfo;
import com.minisheep.model.Knowledge;
import com.minisheep.service.FlightService;
import com.minisheep.service.KnowledgeService;
import com.minisheep.utils.ToolsUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by minisheep on 18/1/8.
 */
@Service
public class FlightServiceImpl implements FlightService{
//    protected static Logger logger = (Logger) LoggerFactory.getLogger(FlightServiceImpl.class);

    @Autowired
    FlightMapper flightMapper;

    @Override
    public List<BaseFlightInfo> flightSearch(String flightCode) {
//        logger.info("这个是查询航班的，航班编号为:" + flightCode);
        List<BaseFlightInfo> flights = new ArrayList<BaseFlightInfo>();
        flights = flightMapper.getListAccordingToFlightCode(flightCode);

        for (int i = 0; i < flights.size(); i++) {
            // 起飞时间(实际、预计、计划)
            flights.get(i).setActualTime((flights.get(i).getActualTime() != null) ? ToolsUtils.removeDotZero(flights.get(i).getActualTime()) : null);
            flights.get(i).setEstimateTime((flights.get(i).getEstimateTime() != null) ? ToolsUtils.removeDotZero(flights.get(i).getEstimateTime()) : null);
            flights.get(i).setScheduleTime((flights.get(i).getScheduleTime() != null) ? ToolsUtils.removeDotZero(flights.get(i).getScheduleTime()) : null);

            // 最后更新时间
            flights.get(i).setLastUpdated((flights.get(i).getLastUpdated() != null) ? ToolsUtils.removeDotZero(flights.get(i).getLastUpdated()) : null);

            // 值机柜台时间
            flights.get(i).setActualCheckinOpen((flights.get(i).getActualCheckinOpen() != null) ? ToolsUtils.removeDotZero(flights.get(i).getActualCheckinOpen()) : null);
            flights.get(i).setActualCheckinClose((flights.get(i).getActualCheckinClose() != null) ? ToolsUtils.removeDotZero(flights.get(i).getActualCheckinClose()) : null);
            flights.get(i).setScheduleCheckinOpen((flights.get(i).getScheduleCheckinOpen() != null) ? ToolsUtils.removeDotZero(flights.get(i).getScheduleCheckinOpen()) : null);
            flights.get(i).setScheduleCheckinClose((flights.get(i).getScheduleCheckinClose() != null) ? ToolsUtils.removeDotZero(flights.get(i).getScheduleCheckinClose()) : null);

            // 行李传送带时间
            flights.get(i).setCarouselScheduleOpen((flights.get(i).getCarouselScheduleOpen() != null) ? ToolsUtils.removeDotZero(flights.get(i).getCarouselScheduleOpen()) : null);
            flights.get(i).setCarouselScheduleClose((flights.get(i).getCarouselScheduleClose() != null) ? ToolsUtils.removeDotZero(flights.get(i).getCarouselScheduleClose()) : null);
            flights.get(i).setCarouselActualOpen((flights.get(i).getCarouselActualOpen() != null) ? ToolsUtils.removeDotZero(flights.get(i).getCarouselActualOpen()) : null);
            flights.get(i).setCarouselActualClose((flights.get(i).getCarouselActualClose() != null) ? ToolsUtils.removeDotZero(flights.get(i).getCarouselActualClose()) : null);

            // 登机口时间(实际、预计、计划)
            flights.get(i).setGateActualOpen((flights.get(i).getGateActualOpen() != null) ? ToolsUtils.removeDotZero(flights.get(i).getGateActualOpen()) : null);
            flights.get(i).setGateActualClose((flights.get(i).getGateActualClose() != null) ? ToolsUtils.removeDotZero(flights.get(i).getGateActualClose()) : null);
            flights.get(i).setGateEstimateOpen((flights.get(i).getGateEstimateOpen() != null) ? ToolsUtils.removeDotZero(flights.get(i).getGateEstimateOpen()) : null);
            flights.get(i).setGateEstimateClose((flights.get(i).getGateEstimateClose() != null) ? ToolsUtils.removeDotZero(flights.get(i).getGateEstimateClose()) : null);
            flights.get(i).setGateScheduleOpen((flights.get(i).getGateScheduleOpen() != null) ? ToolsUtils.removeDotZero(flights.get(i).getGateScheduleOpen()) : null);
            flights.get(i).setGateScheduleClose((flights.get(i).getGateScheduleClose() != null) ? ToolsUtils.removeDotZero(flights.get(i).getGateScheduleClose()) : null);

            flights.get(i).setOpdate((flights.get(i).getOpdate() != null) ? ToolsUtils.removeDotZero(flights.get(i).getOpdate()) : null);
        }
        return flights;
    }

    @Override
    public String getIataCodeByCNName(String displayCnName) {
        return null;
    }

    @Override
    public String getCnNameByIataCode(String iataCode) {
        return null;
    }

    @Override
    public List<BaseFlightInfo> getFlightListFromDepAndArr(String dep, String arr) {
        return null;
    }

    @Override
    public String StatusCodeToDescription(String statusCode) {
        return null;
    }

    @Override
    public Integer dircetionCount(String direction) {
        return null;
    }

    @Override
    public String flightTaskCodeToCNName(String flightTaskCode) {
        return null;
    }

    @Override
    public String companyCodeToCNName(String companyCode) {
        return null;
    }

    @Override
    public String irregularCode(String irrCode) {
        return null;
    }
}
