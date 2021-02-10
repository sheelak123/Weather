package com.spring.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.Model.WeatherDetail;
import com.spring.Model.WeatherDetail.WeatherMain;
import com.spring.Model.WeatherDetailList;
import com.spring.Model.WeatherRequestBody;
import com.spring.util.WeatherUtility;

@Repository
@DefaultProperties
public class WeatherRepo {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WeatherUtility util;

	@HystrixCommand(fallbackMethod="defaultFallBackMethod",commandKey="getWeatherApi")
	public WeatherDetail getWeatherApi(WeatherRequestBody requestBody) {
		System.out.println("First line of getWeatherApi method ");
		String apiLink = util.createUrl(requestBody);
		System.out.println("apiLink *****"+apiLink);
		WeatherDetail detail = restTemplate.getForObject(apiLink, WeatherDetail.class);
		
		/*
		 * String msg = String.format(
		 * "weather response. temp: %s, feels_like: %s, temp_min: %s,temp_max: %s,pressure: %s,humidity:%s"
		 * , detail.getMain().getTemp(),
		 * detail.getMain().getFeels_like(),detail.getMain().getTemp_min(),detail.
		 * getMain().getTemp_max(), detail.getMain().getPressure(),
		 * detail.getMain().getHumidity()); System.out.println(msg);
		 */

		return detail;

	}

	public List<WeatherDetail> getWeatherApiByList(WeatherRequestBody requestBody) {
		// TODO Auto-generated method stub
		String apiLinkList = util.createUrlForList(requestBody);
		WeatherDetailList detailList = restTemplate.getForObject(apiLinkList, WeatherDetailList.class);
		List<WeatherDetail> listResponse=detailList.getList();
		return listResponse;
	}

	public WeatherDetail defaultFallBackMethod(WeatherRequestBody requestBody,Throwable throwable) {
		WeatherDetail detail=new WeatherDetail();
		WeatherMain mainDetail=new WeatherMain();
		mainDetail.setTemp("200.00");
		mainDetail.setFeels_like("200.00");
		mainDetail.setTemp_min("200.00");
		mainDetail.setTemp_max("200.00");
		mainDetail.setPressure("1000");
		mainDetail.setHumidity("10");
		detail.setMain(mainDetail);
		 System.out.printf("fallback******, input:%s, exception:%s%n", requestBody, throwable);
		return detail;
	}
	
}
