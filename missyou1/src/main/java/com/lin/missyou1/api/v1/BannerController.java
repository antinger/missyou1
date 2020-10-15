package com.lin.missyou1.api.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lin.missyou1.exception.http.ForbiddenException;
import com.lin.missyou1.exception.http.NotFoundException;

@RestController
@RequestMapping("/banner")
public class BannerController {

	@GetMapping("/test")
	@ResponseBody	//使用原生的reponse将返回的信息包装处理
	public String test() throws Exception {
		
		throw new ForbiddenException(10001);
	}
	
}
