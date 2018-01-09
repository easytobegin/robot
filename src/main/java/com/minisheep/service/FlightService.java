package com.minisheep.service;

import com.minisheep.model.BaseFlightInfo;

import java.util.List;

/**
 * Created by minisheep on 18/1/8.
 */
public interface FlightService {
    public List<BaseFlightInfo> flightSearch(String flightNo);  // 根据航班编号返回列表

    public String getIataCodeByCNName(String displayCnName); // 根据中文名返回英文简称

    public String getCnNameByIataCode(String iataCode); //根据英文简称返回机场中文名

    public List<BaseFlightInfo> getFlightListFromDepAndArr(String dep, String arr); // 根据出发城市和抵达城市获取航班列表

    public String StatusCodeToDescription(String statusCode);  // 状态码翻译成描述

    public Integer CountByDirection(String direction);  // 获取进港或出港航班总数

    public String flightTaskCodeToCNName(String flightTaskCode); // 任务英文代码转中文

    public String companyCodeToCNName(String companyCode); // 航空公司代号转中文名

    public String irregularCode(String irrCode); // 异常编码转描述
}
