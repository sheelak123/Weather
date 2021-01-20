package com.spring.Repository;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.spring.Model.WeatherDetail;


@Repository
public class WeatherRepo {
	
	
	private RestTemplate restTemplate =new RestTemplate();
	

	  @Value("${api.url}")
	  private String apiUrl;
	  
	  @Value("${api.key}")
	  private String apiKey;
	

	public WeatherDetail getWeatherApi(String cityId) {
		// TODO Auto-generated method stub
		System.out.println(apiUrl+cityId+"&appid="+apiKey);
		
		WeatherDetail detail=restTemplate.getForObject(apiUrl+cityId+"&appid="+apiKey,
				WeatherDetail.class);
		
		
		String msg = String.format(
                "weather response. temp: %s, feels_like: %s, temp_min: %s,temp_max: %s,pressure: %s,humidity:%s",
                 detail.getMain().getTemp(), detail.getMain().getFeels_like(),detail.getMain().getTemp_min(),detail.getMain().getTemp_max(),
                 detail.getMain().getPressure(),
                 detail.getMain().getHumidity());
		System.out.println(msg);
		return detail;

		
		
		
	}
	
	
	

}
