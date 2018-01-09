package com.minisheep.mapper.aiidbDataSourceMapper;

import com.minisheep.model.BaseFlightInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by minisheep on 18/1/7.
 */


/*
    public List<BaseFlightInfo> flightSearch(String filghtNo);  // 根据航班编号返回列表

    public String getIataCodeByCNName(String displayCnName); // 根据中文名返回英文简称

    public String getCnNameByIataCode(String iataCode); //根据英文简称返回机场中文名

    public List<BaseFlightInfo> getFlightListFromDepAndArr(String dep, String arr); // 根据出发城市和抵达城市获取航班列表

    public String StatusCodeToDescription(String statusCode);  // 状态码翻译成描述

    public Integer countByDirection(String direction);

    public String flightTaskCodeToCNName(String flightTaskCode); // 任务英文代码转中文

    public String companyCodeToCNName(String companyCode); // 航空公司代号转中文名

    public String irregularCode(String irrCode); // 异常编码转描述
 */
@Mapper
public interface FlightMapper {
    // 根据航班编号查询List
    @Select("select * from t_flightinfo where flight = #{flightNo}")
    List<BaseFlightInfo> getListAccordingToFlightCode(@Param("flightNo") String flightNo);

    // 根据中文名返回英文简称
    @Select("select iatacode from base_airport where displaycnname = #{displaycnname}")
    String getIataCodeByCNNameSearch(@Param("displaycnname") String displaycnname);

    // 根据英文简称返回机场中文名
    @Select("select displaycnname from base_airport where iatacode = #{iatacode}")
    String getCnNameByIatatCodeSearch(@Param("iatacode") String iatacode);

    // 搜索哪里到哪里(包含经停站,比如问题: 厦门到北京的航班,厦门和北京提取出来搜索)
    @Select("select * from t_flightinfo where " +
            "(origin = #{origin1} and destination = #{destination1}) or " +
            "(origin = #{origin2} and " + "passby = #{destination2}) or " +
            "(passby = #{origin3} and destination = #{destination3})")
    List<BaseFlightInfo> getFlightListFromDepAndArrSearch(@Param("origin1") String origin1,
                                                          @Param("destination1") String destination1,
                                                          @Param("origin2") String origin2,
                                                          @Param("destination2") String destination2,
                                                          @Param("origin3") String origin3,
                                                          @Param("destination3") String destination3);

    // 状态码翻译成描述
    @Select("select * from base_flightstatus where statuscode = #{statuscode}")
    String StatusCodeToDescriptionSearch(@Param("statuscode") String statuscode);

    // 查询抵达和起飞的飞机个数
    @Select("select COUNT(*) from t_flightinfo where direction = #{direction}")
    Integer directionCountSearch(@Param("direction") String direction);

    // 任务英文代码转中文
    @Select("select description from base_flighttask where flighttaskcode = #{flighttaskcode}")
    String flightTaskCodeToCNNameSearch(@Param("flighttaskcode") String flighttaskcode);

    // 航空公司代号转中文名
    @Select("select cnname from base_airlines where iatacode = #{iatacode}")
    String companyCodeToCNNameSearch(@Param("iatacode") String iatacode);

    // 异常编码转描述
    @Select("select description from base_irregularcode where irregularcode = #{irregularcode}")
    String irregularCodeSearch(@Param("irregularcode") String irregularcode);
}
