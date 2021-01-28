package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Model.WeatherDetail;
import com.spring.Model.WeatherDetailList;
import com.spring.Model.WeatherRequestBody;
import com.spring.Repository.WeatherRepo;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepo weatherRepo;

	public WeatherDetail getWeatherService(WeatherRequestBody requestBody) {
		// TODO Auto-generated method stub
		System.out.println("Inside getWeatherService method");
		
		WeatherDetail api = weatherRepo.getWeatherApi(requestBody);
		
		return api;

	}

	
	  public List<WeatherDetail> getWeatherServiceByList(WeatherRequestBody
	  requestBody) { // TODO Auto-generated method stub
	  System.out.println("Inside getWeatherServiceByList method");
	  List<WeatherDetail> apiList = weatherRepo.getWeatherApiByList(requestBody);
	  
	  return apiList; }
	 

}
