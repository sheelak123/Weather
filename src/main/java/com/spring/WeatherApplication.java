package com.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;





@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class WeatherApplication {
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	


	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}

}
