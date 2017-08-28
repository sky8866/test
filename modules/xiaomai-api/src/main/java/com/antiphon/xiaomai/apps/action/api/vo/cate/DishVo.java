package com.antiphon.xiaomai.apps.action.api.vo.cate;

 

import com.antiphon.xiaomai.common.utils.ConfigUtil;
import com.antiphon.xiaomai.modules.entity.cate.Dish; 

public class DishVo {
    
	private String dishId;
	/**
	 * 名称
	 */
	private String name;
 
	
	/**
	 * 价格
	 */
	private String price;
	/**
	 * 单位
	 */
	private String unit;
	 
	
	private String cover; 
	 
	public  DishVo(Dish dish){
		this.dishId=dish.getId()+"";
		this.name=dish.getName();
	 
		this.price=dish.getPrice()+"";
		this.unit=dish.getUnit();
	     if(!dish.getImgs().isEmpty()) this.cover=ConfigUtil.getValue("server")+dish.getImgs().get(0).getImagePath();
	
	}
	
	
	

	public String getDishId() {
		return dishId;
	}




	public void setDishId(String dishId) {
		this.dishId = dishId;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	 
	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

 
	
}
