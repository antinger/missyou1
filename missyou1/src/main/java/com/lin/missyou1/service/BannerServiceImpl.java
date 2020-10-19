package com.lin.missyou1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lin.missyou1.model1.Banner;
import com.lin.missyou1.respository.BannerRespository;

@Service
public class BannerServiceImpl implements BannerService {

	@Autowired
	BannerRespository bannerRespository;
	
	@Override
	public Banner getBannerByName(String name) {
		return bannerRespository.findOneByName(name);
	}

	
	
}
