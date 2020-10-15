package com.lin.missyou1.core.configuration;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.lin.missyou1.core.configuration.hack.AutoPrefixUrlMapping;

@Component
public class AutoPrefixConfiguration implements WebMvcRegistrations {

	@Override
	public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
		// TODO Auto-generated method stub
		return new AutoPrefixUrlMapping();
	}
	
}
