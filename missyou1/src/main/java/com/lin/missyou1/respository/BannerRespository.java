package com.lin.missyou1.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lin.missyou1.model1.Banner;

@Repository
public interface BannerRespository extends JpaRepository<Banner, Long> {

	Banner findOneById(Long id);
	
	Banner findOneByName(String name);
	
}
