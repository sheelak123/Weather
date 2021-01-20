package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Model.WeatherDetail;
import com.spring.Repository.WeatherRepo;


@Service
public class WeatherService {
	
	@Autowired
	private WeatherRepo weatherRepo;
	

	public WeatherDetail getWeatherService(String cityId) {
		// TODO Auto-generated method stub
		
		WeatherDetail api=weatherRepo.getWeatherApi(cityId);
		return api;
		
	}

}
