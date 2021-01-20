package com.spring.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Model.WeatherDetail;
import com.spring.service.WeatherService;



@Controller
public class WeatherController {
	
	Logger logger=LoggerFactory.getLogger(WeatherController.class);
	
	@Autowired
	private WeatherService weatherService;
	
	
	
	@ResponseBody	
	@RequestMapping("/Weather")
	public WeatherDetail getWeather(@RequestParam("cityId") String cityId) {
		
		logger.info("getWeather method accessed");
	
		WeatherDetail service=weatherService.getWeatherService(cityId);
		

		return service;
		
	}

}
