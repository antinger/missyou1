package com.lin.missyou1.model1;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Theme {

	@Id
	private Long id;
	
	private String title;
	
	private String name;
	
	@ManyToMany
	private List<Spu> spuList;
	
}
