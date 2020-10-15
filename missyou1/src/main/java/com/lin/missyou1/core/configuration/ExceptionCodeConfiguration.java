package com.lin.missyou1.core.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="lin")
@PropertySource(value="classpath:config/exception-code.properties")
@Component
public class ExceptionCodeConfiguration {

	private Map<Integer, String> codes = new HashMap<Integer, String>();
	
	Map<Integer, String> getCodes() {
		return codes;
	}
	
	void setCodes(Map<Integer, String> codes) {
		this.codes = codes;
	}

	public String getMessage(Integer code) {
		String message = codes.get(code);
		return message;
	}
	
}
