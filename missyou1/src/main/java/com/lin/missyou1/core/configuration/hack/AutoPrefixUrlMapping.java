package com.lin.missyou1.core.configuration.hack;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

public class AutoPrefixUrlMapping extends RequestMappingHandlerMapping {
	
	@Value("${missyou1.api-package}")
	private String apiPackagePath;
	
	@Override
	protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
		RequestMappingInfo requestMappingInfo = super.getMappingForMethod(method, handlerType);
		if(requestMappingInfo != null) {
			String prefixUrl = getPrefixUrl(handlerType);
			return RequestMappingInfo.paths(prefixUrl).build().combine(requestMappingInfo);
		}
		return requestMappingInfo;
	}
	
	private String getPrefixUrl(Class<?> handlerType) {
		String packageName = handlerType.getPackage().getName();
		packageName = packageName.replaceAll(apiPackagePath, "");
		return packageName.replace(".", "/");
	}

}
