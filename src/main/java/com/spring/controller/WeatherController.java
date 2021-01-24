package com.spring.controller;

import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.spring.Model.WeatherDetail;
import com.spring.Model.WeatherDetailList;
import com.spring.Model.WeatherRequestBody;
import com.spring.service.WeatherService;

@RestController
@RequestMapping
public class WeatherController {

	Logger logger = LoggerFactory.getLogger(WeatherController.class);

	@Autowired
	private WeatherService weatherService;

	WeatherRequestBody requestBody = new WeatherRequestBody();

	// @RequestMapping(method = RequestMethod.GET,
	// produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping("/Weather")
	public WeatherDetail getWeather(@RequestParam("cityName") Optional<String> cityName,
			@RequestParam Optional<String> stateCode, @RequestParam Optional<String> countryCode,
			@RequestParam("cityId") Optional<String> cityId, @RequestParam("zipCode") Optional<String> zipCode) {

		logger.info("getWeather method accessed");

		requestBody.setCityName(cityName);
		requestBody.setStatecode(stateCode);
		requestBody.setCountryCode(countryCode);
		requestBody.setCityId(cityId);
		requestBody.setZipCode(zipCode);
		
		WeatherDetail service = weatherService.getWeatherService(requestBody);
		return service;
		
	}
		
		@RequestMapping("/group")
		public List<WeatherDetail> getWeatherByIdList(
				@RequestParam("idList") Optional<List<String>> idList) {

			logger.info("getWeatherByIdList  method accessed");
			requestBody.setIdList(idList);
			List<WeatherDetail> serviceList = weatherService.getWeatherServiceByList(requestBody);
			return serviceList;

	}

}
