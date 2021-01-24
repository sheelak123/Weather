package com.spring.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.spring.Model.WeatherRequestBody;

@Component
public class WeatherUtility {

	@Value("${api.url}")
	private String apiUrl;

	@Value("${api.key}")
	private String apiKey;

	@Value("${api.groupurl}")
	private String idListUrl;
	
	
	@Value("${env.desc}")
    private String envDesc;

	Logger logger = LoggerFactory.getLogger(WeatherUtility.class);
	
	String url = null;

	public String createUrl(WeatherRequestBody requestBody) {
		// TODO Auto-generated method stub
		System.out.printf("Environment Description : %s    ", envDesc);
		
		String qString = null;
		String idString = null;
		String zipString = null;
		
		

		if (requestBody.getCityName().isPresent()) {
			qString = requestBody.getCityName().get();
		}

		if (requestBody.getStatecode().isPresent()) {
			qString = qString + "," + requestBody.getStatecode().get();
		}

		if (requestBody.getCountryCode().isPresent() && qString != null) {
			qString = qString + "," + requestBody.getCountryCode().get();

		}

		if (requestBody.getCityId().isPresent()) {
			idString = requestBody.getCityId().get();
		}

		if (requestBody.getZipCode().isPresent()) {
			zipString = requestBody.getZipCode().get();
			if (requestBody.getCountryCode().isPresent()) {
				zipString = zipString + "," + requestBody.getCountryCode().get();
			}
		}

		

		if (qString != null) {
			url = apiUrl + "q=" + qString + "&appid=" + apiKey;
		}
		if (idString != null) {
			url = apiUrl + "id=" + idString + "&appid=" + apiKey;
		}
		if (zipString != null) {

			url = apiUrl + "zip=" + zipString + "&appid=" + apiKey;
		}
		
		logger.info("Url : " + url);
		return url;

	}

	public String createUrlForList(WeatherRequestBody requestBody) {
		// TODO Auto-generated method stub
		String idList = null;
		if (requestBody.getIdList().isPresent()) {
			System.out.println("Inside getIdList *****");
			Optional<List<String>> ls = Optional.of(new ArrayList<String>());
			ls = requestBody.getIdList();

			/*
			 * List<String>
			 * filteredList=ls.stream().flatMap(l->l.stream()).collect(Collectors.toList());
			 * idList=String.join(",", filteredList);
			 */

			Stream<String> stream = ls.map(List::stream).orElse(Stream.empty());
			idList = stream.map(Object::toString).collect(Collectors.joining(","));
			System.out.println("idList :" + stream);

		}
		if (idList != null) {

			url = idListUrl + "id=" + idList + "&appid=" + apiKey;
		}
		logger.info("Url : " + url);
		return url;
	}

}
