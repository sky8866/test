package com.antiphon.xiaomai.apps.action.api.vo.cate;

import java.util.ArrayList;
import java.util.List;

import com.antiphon.xiaomai.common.utils.ConfigUtil;
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.entity.cate.CateShop;
import com.antiphon.xiaomai.modules.entity.img.Imgs;
 

public class CateShopIndexVo {
	
	     private String shopId;
	/**
	    * 店名
	    */
		private String name;
	   /**
	    * 店类型
	    */
	   private String type;
	 
	   
	   /**
	    * 地址
	    */
	   private String address;
	     
	   
	   /**
	    * 人均消费
	    */
	   
	   private String consumption;
	     
	   
	   private String cover;
	   
	    private String info;

	   
	   public CateShopIndexVo(CateShop s){
		   this.shopId=s.getId()+"";
		    this.name=s.getName(); 
		    type=s.getType();
		   
		    address=s.getAddress(); 
		    
		    consumption=s.getConsumption();
		     
		    if(StringUtils.isNotEmpty(s.getCover())){
		    	
		    	 this.cover=ConfigUtil.getValue("server")+s.getCoverPath();
		    }
	        
		 
		    
		    
	   }





	public String getShopId() {
		return shopId;
	}





	public void setShopId(String shopId) {
		this.shopId = shopId;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getType() {
		return type;
	}





	public void setType(String type) {
		this.type = type;
	}





	public String getAddress() {
		return address;
	}





	public void setAddress(String address) {
		this.address = address;
	}





	public String getConsumption() {
		return consumption;
	}





	public void setConsumption(String consumption) {
		this.consumption = consumption;
	}





	public String getCover() {
		return cover;
	}





	public void setCover(String cover) {
		this.cover = cover;
	}





	public String getInfo() {
		return info;
	}





	public void setInfo(String info) {
		this.info = info;
	}
	   
	 
	   
}
