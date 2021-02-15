package com.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "api")
public class ApiConfig {
	
	private String url; 
    private String  key; 
    private String groupurl; 
    
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getGroupurl() {
		return groupurl;
	}
	public void setGroupurl(String groupurl) {
		this.groupurl = groupurl;
	}
	
	@Override
    public String toString() {
        return "MyApiProperties{" +
                "\n url=" + url +
                ",\n key=" + key +
                ",\n groupurl=" + groupurl +
                "\n}";
    }

}
