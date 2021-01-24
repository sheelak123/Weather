package com.spring.Model;

public class WeatherDetail {
	
	private WeatherMain main;
	
	
	public WeatherMain getMain() {
		return main;
	}



	public void setMain(WeatherMain main) {
		this.main = main;
	}

	public WeatherDetail() {
		
	}

	public WeatherDetail(WeatherMain main) {
        this.main = main;
        
    }
	
	
	
public static class  WeatherMain {
	private String temp;
	private String feels_like;
	private String temp_min;
	private String temp_max;
	private String pressure;
	private String humidity;
	
	public WeatherMain() {
		
	}
	
public WeatherMain(String temp,String feels_like,String temp_min,String temp_max,String pressure,String humidity) {
	this.temp=temp;
	this.feels_like=feels_like;
	this.temp_min=temp_min;
	this.temp_max=temp_max;
	this.pressure=pressure;
	this.humidity=humidity;
	
	
}
	
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getFeels_like() {
		return feels_like;
	}
	public void setFeels_like(String feels_like) {
		this.feels_like = feels_like;
	}
	public String getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(String temp_min) {
		this.temp_min = temp_min;
	}
	public String getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(String temp_max) {
		this.temp_max = temp_max;
	}
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	
	@Override
	public String toString () {
	    return "User{" +
	                        "temp=" + temp +
	                        ", feels_like='" + feels_like + '\'' +
	                        ", temp_min='" + temp_min + '\'' +
	                        ", temp_max='" + temp_max + '\'' +
	                        '}';
	}
	
	}



	

}
