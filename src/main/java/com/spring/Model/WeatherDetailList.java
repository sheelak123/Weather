package com.spring.Model;

import java.util.ArrayList;
import java.util.List;

public class WeatherDetailList {
	
	private List<WeatherDetail> list;
	
	public WeatherDetailList() {
		
	}
	
	public WeatherDetailList(List<WeatherDetail> list) {
		list=new ArrayList<>();
	}

	public List<WeatherDetail> getList() {
		return list;
	}

	public void setList(List<WeatherDetail> list) {
		this.list = list;
	}

	
	

}
