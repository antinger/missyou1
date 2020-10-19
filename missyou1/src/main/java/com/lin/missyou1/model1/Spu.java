package com.lin.missyou1.model1;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Spu {

	private Long id;
	
	private String title;
	
	private String subtitle;
	
	@ManyToMany
	private List<Theme> themeList;
	
}
