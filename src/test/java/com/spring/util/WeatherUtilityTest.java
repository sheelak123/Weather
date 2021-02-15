package com.spring.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.spring.Model.WeatherRequestBody;
import com.spring.config.ApiConfig;

@ExtendWith(SpringExtension.class) // integrates Spring's TestContext framework with JUnit5
@EnableConfigurationProperties(value = ApiConfig.class)
@TestPropertySource("classpath:applicationtest.properties")
class WeatherUtilityTest {

	@Autowired
	private ApiConfig apiConfig;

	private WeatherRequestBody requestBody;

	private WeatherUtility util;

	@BeforeEach
	public void initEach() {
		System.out.println("Before Each initEach() method called");
		util = new WeatherUtility(apiConfig);
		requestBody = new WeatherRequestBody();
	}

	@Test
	void testCreateUrl() {
		System.out.println("======TEST ONE EXECUTED=======");
		Optional<String> cityId = Optional.ofNullable("2172797");
		requestBody.setCityName(Optional.empty());
		requestBody.setStatecode(Optional.empty());
		requestBody.setCountryCode(Optional.empty());
		requestBody.setZipCode(Optional.empty());
		System.out.println("url" + apiConfig.getUrl());
		requestBody.setCityId(cityId);
		String result1 = util.createUrl(requestBody);
		Assertions.assertEquals(
				"http://api.openweathermap.org/data/2.5/weather?id=2172797&appid=80ef4f9656b54e6e700d5545afc4f41a",
				result1);

	}
	
	
	@Test
	void testCreateUrlForList() {
		System.out.println("======TEST TWO EXECUTED=======");
		
		List<String> idList = Arrays.asList(
			      "524901", "703448", "2172797");
			    Optional<List<String>> listOptional = Optional.of(idList);
		requestBody.setIdList(listOptional);
		String result2 = util.createUrlForList(requestBody);
		Assertions.assertEquals(
				"http://api.openweathermap.org/data/2.5/group?id=524901,703448,2172797&appid=80ef4f9656b54e6e700d5545afc4f41a",
				result2);
		
	}

	
}
