package com.antiphon.xiaomai.apps.action.api.vo.cate;

import java.util.ArrayList;
import java.util.List;

import com.antiphon.xiaomai.modules.entity.cate.Category;
import com.antiphon.xiaomai.modules.entity.city.City;
import com.antiphon.xiaomai.modules.entity.city.District;
 

public class CategoryVo { 
 
 
	 
	 private String name;
	
 
	public CategoryVo(Category c){
		this.name=c.getName();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	 
	 
	 
	 
	 
	 
	
}
