package com.lin.missyou1.model1;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Banner {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//生成主键
	private Long id;
	
	//控制在数据库中生成的字段长度
	@Column(length=16)
	private String name;
	
	//@Transient:不需要在数据库中生成字段
	private String description;
	
	private String img;
	
	private String title;
	
	@OneToMany(mappedBy="banner", fetch=FetchType.EAGER)
	private List<BannerItem> items;
	
}
