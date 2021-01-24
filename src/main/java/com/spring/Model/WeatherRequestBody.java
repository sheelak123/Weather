package com.spring.Model;

import java.util.List;
import java.util.Optional;

public class WeatherRequestBody {
	
	
	private Optional<String> cityName;
	private Optional<String> statecode;
	private Optional<String> countryCode;
	private Optional<String> cityId;
	private Optional<String> zipCode; 
	private Optional<List<String>>  idList;

	
	
	public Optional<List<String>> getIdList() {
		return idList;
	}
	public void setIdList(Optional<List<String>> idList) {
		this.idList = idList;
	}
	public Optional<String> getZipCode() {
		return zipCode;
	}
	public void setZipCode(Optional<String> zipCode) {
		this.zipCode = zipCode;
	}
	
	
	
	public Optional<String> getCityId() {
		return cityId;
	}
	public void setCityId(Optional<String> cityId) {
		this.cityId = cityId;
	}
	public Optional<String> getCityName() {
		return cityName;
	}
	public void setCityName(Optional<String> cityName) {
		this.cityName = cityName;
	}
	public Optional<String> getStatecode() {
		return statecode;
	}
	public void setStatecode(Optional<String> statecode) {
		this.statecode = statecode;
	}
	public Optional<String> getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(Optional<String> countryCode) {
		this.countryCode = countryCode;
	}
	@Override
	public String toString () {
	    return "User{" +
	                        "cityName=" + cityName +
	                        ", statecode='" + statecode + '\'' +
	                        ", countryCode='" + countryCode + '\'' +
	                        "cityId=" + cityId+'\''+
	                        "zipCode=" + zipCode+
	                        '}';
	}


}
