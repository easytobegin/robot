package com.minisheep.service.impl;

import com.minisheep.mapper.aiidbDataSourceMapper.FlightMapper;
import com.minisheep.model.BaseFlightInfo;
import com.minisheep.service.FlightService;
import com.minisheep.utils.ToolsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minisheep on 18/1/8.
 */
@Service
public class FlightServiceImpl implements FlightService{
//    protected static Logger logger = (Logger) LoggerFactory.getLogger(FlightService.class);

    @Autowired
    FlightMapper flightMapper;

    private List<BaseFlightInfo> afterRemoveDotZeroOperatorFlights(List<BaseFlightInfo> flights) {  // 返回去除从数据库读取末尾.0的flights信息
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
    public List<BaseFlightInfo> flightSearch(String flightCode) {
//        logger.info("这个是查询航班的，航班编号为:" + flightCode);
        List<BaseFlightInfo> flights = new ArrayList<BaseFlightInfo>();
        flights = flightMapper.getListAccordingToFlightCode(flightCode);

        return afterRemoveDotZeroOperatorFlights(flights);
    }

    @Override
    public String getIataCodeByCNName(String displayCnName) {
        return (flightMapper.getIataCodeByCNNameSearch(displayCnName) != null) ? flightMapper.getIataCodeByCNNameSearch(displayCnName) : null;
    }

    @Override
    public String getCnNameByIataCode(String iataCode) {
        return (flightMapper.getCnNameByIatatCodeSearch(iataCode) != null) ? flightMapper.getCnNameByIatatCodeSearch(iataCode) : null;
    }

    @Override
    public List<BaseFlightInfo> getFlightListFromDepAndArr(String dep, String arr) {
        List<BaseFlightInfo> flights = new ArrayList<BaseFlightInfo>();
        flights = flightMapper.getFlightListFromDepAndArrSearch(dep, arr, dep, arr, dep, arr);

        return afterRemoveDotZeroOperatorFlights(flights);
    }

    @Override
    public String StatusCodeToDescription(String statusCode) {
        return (flightMapper.StatusCodeToDescriptionSearch(statusCode) != null) ? flightMapper.StatusCodeToDescriptionSearch(statusCode) : null;
    }

    @Override
    public Integer CountByDirection(String direction) {
        return (flightMapper.directionCountSearch(direction) != null) ? flightMapper.directionCountSearch(direction) : null;
    }

    @Override
    public String flightTaskCodeToCNName(String flightTaskCode) {
        return (flightMapper.flightTaskCodeToCNNameSearch(flightTaskCode) != null) ? flightMapper.flightTaskCodeToCNNameSearch(flightTaskCode) : null;
    }

    @Override
    public String companyCodeToCNName(String companyCode) {
        return (flightMapper.companyCodeToCNNameSearch(companyCode) != null) ? flightMapper.companyCodeToCNNameSearch(companyCode) : null;
    }

    @Override
    public String irregularCode(String irrCode) {
        return (flightMapper.irregularCodeSearch(irrCode) != null) ? flightMapper.irregularCodeSearch(irrCode) : null;
    }
}
