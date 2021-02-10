package com.spring.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.spring.Model.WeatherRequestBody;

class WeatherUtilityTest {

	
	
	private final WeatherUtility util=new WeatherUtility();
	private WeatherRequestBody requestBody=new WeatherRequestBody();
	
	
	
	@Test
	void testCreateUrl() {
		System.out.println("======TEST ONE EXECUTED=======");
		Optional<String> cityId=Optional.ofNullable("2172797");
		requestBody.setCityId(cityId);
		String result=util.createUrl(requestBody);
		Assertions.assertEquals("http://api.openweathermap.org/data/2.5/weather?id=2172797&appid=80ef4f9656b54e6e700d5545afc4f41a",
				           result);
		
	}

}
