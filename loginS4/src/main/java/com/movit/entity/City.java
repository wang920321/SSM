package com.movit.entity;

import java.util.List;

public class City {

    private String city;

    private String cnty;

    private String id;

    private String lat;

    private String lon;

    private List<String> updateTime;

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getCnty() {
	return cnty;
    }

    public void setCnty(String cnty) {
	this.cnty = cnty;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getLat() {
	return lat;
    }

    public void setLat(String lat) {
	this.lat = lat;
    }

    public String getLon() {
	return lon;
    }

    public void setLon(String lon) {
	this.lon = lon;
    }

    public List<String> getUpdateTime() {
	return updateTime;
    }

    public void setUpdateTime(List<String> updateTime) {
	this.updateTime = updateTime;
    }

}
