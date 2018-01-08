package com.minisheep.model;

import java.util.Date;

/**
 * Created by minisheep on 18/1/6.
 */

public class BaseAirlines {
    private Integer airlinesid;

    private String iatacode;

    private String icaocode;

    private String airlinesnature;

    private String cnname;

    private String enname;

    private String cnabbr;

    private String enabbr;

    private String countrycode;

    private String generalagent;

    private Date lastupdated;

    public Integer getAirlinesid() {
        return airlinesid;
    }

    public void setAirlinesid(Integer airlinesid) {
        this.airlinesid = airlinesid;
    }

    public String getIatacode() {
        return iatacode;
    }

    public void setIatacode(String iatacode) {
        this.iatacode = iatacode;
    }

    public String getIcaocode() {
        return icaocode;
    }

    public void setIcaocode(String icaocode) {
        this.icaocode = icaocode;
    }

    public String getAirlinesnature() {
        return airlinesnature;
    }

    public void setAirlinesnature(String airlinesnature) {
        this.airlinesnature = airlinesnature;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public String getCnabbr() {
        return cnabbr;
    }

    public void setCnabbr(String cnabbr) {
        this.cnabbr = cnabbr;
    }

    public String getEnabbr() {
        return enabbr;
    }

    public void setEnabbr(String enabbr) {
        this.enabbr = enabbr;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getGeneralagent() {
        return generalagent;
    }

    public void setGeneralagent(String generalagent) {
        this.generalagent = generalagent;
    }

    public Date getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(Date lastupdated) {
        this.lastupdated = lastupdated;
    }
}
