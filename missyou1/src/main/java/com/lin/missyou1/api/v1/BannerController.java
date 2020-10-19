package com.lin.missyou1.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.lin.missyou1.model1.Banner;
import com.lin.missyou1.service.BannerService;

@RestController
@RequestMapping("/banner")
public class BannerController {

	@Autowired
	BannerService bannerServiceImpl;
	
	@GetMapping("/test/{name}")
	@ResponseBody	//使用原生的reponse将返回的信息包装处理
	public String test(@PathVariable("name") String name) throws Exception {
		System.out.println(name);
		Banner banner = bannerServiceImpl.getBannerByName(name);
		System.out.println(banner);
		return JSONObject.toJSONString(banner).toString();
	}
	
}
